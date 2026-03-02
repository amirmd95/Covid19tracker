import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { GlobalStats } from '../models/global-stats.model';
import { CountryStats } from '../models/country-stats.model';

@Injectable({
  providedIn: 'root'
})
export class Covid19Service {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getGlobalStats(): Observable<GlobalStats> {
    return this.http.get<GlobalStats>(`${this.apiUrl}/global`);
  }

  getAllCountriesStats(): Observable<CountryStats[]> {
    return this.http.get<CountryStats[]>(`${this.apiUrl}/countries`);
  }

  getCountryStats(country: string): Observable<CountryStats> {
    return this.http.get<CountryStats>(`${this.apiUrl}/countries/${country}`);
  }

  getTopCountriesByCases(limit: number = 10): Observable<CountryStats[]> {
    return this.http.get<CountryStats[]>(`${this.apiUrl}/countries/top/cases?limit=${limit}`);
  }

  getTopCountriesByDeaths(limit: number = 10): Observable<CountryStats[]> {
    return this.http.get<CountryStats[]>(`${this.apiUrl}/countries/top/deaths?limit=${limit}`);
  }

  getTopCountriesByRecovered(limit: number = 10): Observable<CountryStats[]> {
    return this.http.get<CountryStats[]>(`${this.apiUrl}/countries/top/recovered?limit=${limit}`);
  }

  refreshData(): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/refresh`, {});
  }
}

