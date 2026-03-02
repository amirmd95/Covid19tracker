package com.covid19.tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "global_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long cases;

    @Column(name = "today_cases")
    private Long todayCases;

    @Column(nullable = false)
    private Long deaths;

    @Column(name = "today_deaths")
    private Long todayDeaths;

    @Column(nullable = false)
    private Long recovered;

    @Column(name = "today_recovered")
    private Long todayRecovered;

    @Column(nullable = false)
    private Long active;

    @Column(nullable = false)
    private Long critical;

    @Column(name = "cases_per_one_million")
    private Double casesPerOneMillion;

    @Column(name = "deaths_per_one_million")
    private Double deathsPerOneMillion;

    @Column(name = "recovered_per_one_million")
    private Double recoveredPerOneMillion;

    @Column(name = "critical_per_one_million")
    private Double criticalPerOneMillion;

    @Column(nullable = false)
    private Long tests;

    @Column(name = "tests_per_one_million")
    private Double testsPerOneMillion;

    @Column(nullable = false)
    private Long population;

    @Column(name = "affected_countries")
    private Integer affectedCountries;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    protected void onCreate() {
        updatedAt = LocalDateTime.now();
    }
}

