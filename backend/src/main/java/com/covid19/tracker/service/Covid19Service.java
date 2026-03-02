package com.covid19.tracker.service;

import com.covid19.tracker.dto.CountryStatsDTO;
import com.covid19.tracker.dto.GlobalStatsDTO;
import com.covid19.tracker.model.CountryStats;
import com.covid19.tracker.model.GlobalStats;
import com.covid19.tracker.repository.CountryStatsRepository;
import com.covid19.tracker.repository.GlobalStatsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class Covid19Service {

    private final WebClient webClient;
    private final GlobalStatsRepository globalStatsRepository;
    private final CountryStatsRepository countryStatsRepository;

    @Cacheable("globalStats")
    public GlobalStats getGlobalStats() {
        log.info("Fetching global COVID-19 statistics");
        return globalStatsRepository.findFirstByOrderByUpdatedAtDesc()
                .orElseGet(this::fetchAndSaveGlobalStats);
    }

    @Cacheable("allCountries")
    public List<CountryStats> getAllCountriesStats() {
        log.info("Fetching all countries COVID-19 statistics");
        List<CountryStats> stats = countryStatsRepository.findAll();
        if (stats.isEmpty()) {
            fetchAndSaveAllCountriesStats();
            stats = countryStatsRepository.findAll();
        }
        return stats;
    }

    public CountryStats getCountryStats(String country) {
        log.info("Fetching COVID-19 statistics for country: {}", country);
        return countryStatsRepository.findByCountry(country)
                .orElseGet(() -> fetchAndSaveCountryStats(country));
    }

    public List<CountryStats> getTopCountriesByCases(int limit) {
        log.info("Fetching top {} countries by cases", limit);
        return countryStatsRepository.findTop10ByOrderByCasesDesc();
    }

    public List<CountryStats> getTopCountriesByDeaths(int limit) {
        log.info("Fetching top {} countries by deaths", limit);
        return countryStatsRepository.findTop10ByOrderByDeathsDesc();
    }

    public List<CountryStats> getTopCountriesByRecovered(int limit) {
        log.info("Fetching top {} countries by recovered", limit);
        return countryStatsRepository.findTop10ByOrderByRecoveredDesc();
    }

    @Scheduled(fixedRate = 3600000) // Every hour
    public void updateCovidData() {
        log.info("Scheduled update of COVID-19 data started");
        fetchAndSaveGlobalStats();
        fetchAndSaveAllCountriesStats();
        log.info("Scheduled update of COVID-19 data completed");
    }

    private GlobalStats fetchAndSaveGlobalStats() {
        try {
            GlobalStatsDTO dto = webClient.get()
                    .uri("/all")
                    .retrieve()
                    .bodyToMono(GlobalStatsDTO.class)
                    .block();

            if (dto != null) {
                GlobalStats stats = mapToGlobalStats(dto);
                return globalStatsRepository.save(stats);
            }
        } catch (Exception e) {
            log.error("Error fetching global statistics", e);
        }
        return new GlobalStats();
    }

    private void fetchAndSaveAllCountriesStats() {
        try {
            List<CountryStatsDTO> dtoList = webClient.get()
                    .uri("/countries")
                    .retrieve()
                    .bodyToFlux(CountryStatsDTO.class)
                    .collectList()
                    .block();

            if (dtoList != null && !dtoList.isEmpty()) {
                // Clear existing data
                countryStatsRepository.deleteAll();

                // Save new data
                List<CountryStats> statsList = dtoList.stream()
                        .map(this::mapToCountryStats)
                        .toList();
                countryStatsRepository.saveAll(statsList);
                log.info("Saved statistics for {} countries", statsList.size());
            }
        } catch (Exception e) {
            log.error("Error fetching all countries statistics", e);
        }
    }

    private CountryStats fetchAndSaveCountryStats(String country) {
        try {
            CountryStatsDTO dto = webClient.get()
                    .uri("/countries/" + country)
                    .retrieve()
                    .bodyToMono(CountryStatsDTO.class)
                    .block();

            if (dto != null) {
                CountryStats stats = mapToCountryStats(dto);
                return countryStatsRepository.save(stats);
            }
        } catch (Exception e) {
            log.error("Error fetching statistics for country: {}", country, e);
        }
        return new CountryStats();
    }

    private GlobalStats mapToGlobalStats(GlobalStatsDTO dto) {
        GlobalStats stats = new GlobalStats();
        stats.setCases(dto.getCases());
        stats.setTodayCases(dto.getTodayCases());
        stats.setDeaths(dto.getDeaths());
        stats.setTodayDeaths(dto.getTodayDeaths());
        stats.setRecovered(dto.getRecovered());
        stats.setTodayRecovered(dto.getTodayRecovered());
        stats.setActive(dto.getActive());
        stats.setCritical(dto.getCritical());
        stats.setCasesPerOneMillion(dto.getCasesPerOneMillion());
        stats.setDeathsPerOneMillion(dto.getDeathsPerOneMillion());
        stats.setRecoveredPerOneMillion(dto.getRecoveredPerOneMillion());
        stats.setCriticalPerOneMillion(dto.getCriticalPerOneMillion());
        stats.setTests(dto.getTests());
        stats.setTestsPerOneMillion(dto.getTestsPerOneMillion());
        stats.setPopulation(dto.getPopulation());
        stats.setAffectedCountries(dto.getAffectedCountries());
        stats.setUpdatedAt(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dto.getUpdated()),
                ZoneId.systemDefault()));
        return stats;
    }

    private CountryStats mapToCountryStats(CountryStatsDTO dto) {
        CountryStats stats = new CountryStats();
        stats.setCountry(dto.getCountry());
        stats.setCountryCode(dto.getCountryInfo() != null ? dto.getCountryInfo().getIso2() : null);
        stats.setCases(dto.getCases());
        stats.setTodayCases(dto.getTodayCases());
        stats.setDeaths(dto.getDeaths());
        stats.setTodayDeaths(dto.getTodayDeaths());
        stats.setRecovered(dto.getRecovered());
        stats.setTodayRecovered(dto.getTodayRecovered());
        stats.setActive(dto.getActive());
        stats.setCritical(dto.getCritical());
        stats.setCasesPerOneMillion(dto.getCasesPerOneMillion());
        stats.setDeathsPerOneMillion(dto.getDeathsPerOneMillion());
        stats.setTests(dto.getTests());
        stats.setTestsPerOneMillion(dto.getTestsPerOneMillion());
        stats.setPopulation(dto.getPopulation());
        stats.setFlagUrl(dto.getCountryInfo() != null ? dto.getCountryInfo().getFlag() : null);
        stats.setUpdatedAt(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dto.getUpdated()),
                ZoneId.systemDefault()));
        return stats;
    }
}

