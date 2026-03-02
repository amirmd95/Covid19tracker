package com.covid19.tracker.controller;

import com.covid19.tracker.model.CountryStats;
import com.covid19.tracker.model.GlobalStats;
import com.covid19.tracker.service.Covid19Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/covid19")
@RequiredArgsConstructor
public class Covid19Controller {

    private final Covid19Service covid19Service;

    @GetMapping("/global")
    public ResponseEntity<GlobalStats> getGlobalStats() {
        return ResponseEntity.ok(covid19Service.getGlobalStats());
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryStats>> getAllCountriesStats() {
        return ResponseEntity.ok(covid19Service.getAllCountriesStats());
    }

    @GetMapping("/countries/{country}")
    public ResponseEntity<CountryStats> getCountryStats(@PathVariable String country) {
        return ResponseEntity.ok(covid19Service.getCountryStats(country));
    }

    @GetMapping("/countries/top/cases")
    public ResponseEntity<List<CountryStats>> getTopCountriesByCases(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(covid19Service.getTopCountriesByCases(limit));
    }

    @GetMapping("/countries/top/deaths")
    public ResponseEntity<List<CountryStats>> getTopCountriesByDeaths(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(covid19Service.getTopCountriesByDeaths(limit));
    }

    @GetMapping("/countries/top/recovered")
    public ResponseEntity<List<CountryStats>> getTopCountriesByRecovered(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(covid19Service.getTopCountriesByRecovered(limit));
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshData() {
        covid19Service.updateCovidData();
        return ResponseEntity.ok("Data refresh initiated");
    }
}

