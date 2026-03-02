package com.covid19.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryStatsDTO {

    private String country;

    @JsonProperty("countryInfo")
    private CountryInfo countryInfo;

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

    private Long tests;

    @JsonProperty("testsPerOneMillion")
    private Double testsPerOneMillion;

    private Long population;

    private Long updated;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CountryInfo {
        @JsonProperty("_id")
        private Integer id;

        @JsonProperty("iso2")
        private String iso2;

        @JsonProperty("iso3")
        private String iso3;

        private Double lat;
        private Double lng;
        private String flag;
    }
}

