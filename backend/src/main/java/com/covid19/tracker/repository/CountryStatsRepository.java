package com.covid19.tracker.repository;

import com.covid19.tracker.model.CountryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryStatsRepository extends JpaRepository<CountryStats, Long> {

    Optional<CountryStats> findByCountry(String country);

    List<CountryStats> findTop10ByOrderByCasesDesc();

    List<CountryStats> findTop10ByOrderByDeathsDesc();

    List<CountryStats> findTop10ByOrderByRecoveredDesc();
}

