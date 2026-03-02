export interface GlobalStats {
  id?: number;
  cases: number;
  todayCases: number;
  deaths: number;
  todayDeaths: number;
  recovered: number;
  todayRecovered: number;
  active: number;
  critical: number;
  casesPerOneMillion: number;
  deathsPerOneMillion: number;
  recoveredPerOneMillion: number;
  criticalPerOneMillion: number;
  tests: number;
  testsPerOneMillion: number;
  population: number;
  affectedCountries: number;
  updatedAt: string;
}

