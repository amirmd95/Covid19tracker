package com.covid19.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalStatsDTO {

    private Long cases;

    @JsonProperty("todayCases")
    private Long todayCases;

    private Long deaths;

    @JsonProperty("todayDeaths")
    private Long todayDeaths;

    private Long recovered;

    @JsonProperty("todayRecovered")
    private Long todayRecovered;

    private Long active;

    private Long critical;

    @JsonProperty("casesPerOneMillion")
    private Double casesPerOneMillion;

    @JsonProperty("deathsPerOneMillion")
    private Double deathsPerOneMillion;

    @JsonProperty("recoveredPerOneMillion")
    private Double recoveredPerOneMillion;

    @JsonProperty("criticalPerOneMillion")
    private Double criticalPerOneMillion;

    private Long tests;

    @JsonProperty("testsPerOneMillion")
    private Double testsPerOneMillion;

    private Long population;

    @JsonProperty("affectedCountries")
    private Integer affectedCountries;

    private Long updated;
}

