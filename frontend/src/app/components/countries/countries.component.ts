import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CountryStats } from '../../models/country-stats.model';
import { Covid19Service } from '../../services/covid19.service';

@Component({
  selector: 'app-countries',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {
  countries: CountryStats[] = [];
  filteredCountries: CountryStats[] = [];
  searchTerm = '';
  loading = false;
  error: string | null = null;
  sortBy: 'cases' | 'deaths' | 'recovered' = 'cases';
  sortOrder: 'asc' | 'desc' = 'desc';

  constructor(private covid19Service: Covid19Service) { }

  ngOnInit(): void {
    this.loadCountries();
  }

  loadCountries(): void {
    this.loading = true;
    this.error = null;
    this.covid19Service.getAllCountriesStats().subscribe({
      next: (data) => {
        this.countries = data;
        this.filteredCountries = data;
        this.sortCountries();
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load countries data';
        this.loading = false;
        console.error(err);
      }
    });
  }

  filterCountries(): void {
    if (!this.searchTerm) {
      this.filteredCountries = this.countries;
    } else {
      this.filteredCountries = this.countries.filter(country =>
        country.country.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }
    this.sortCountries();
  }

  sortCountries(): void {
    this.filteredCountries.sort((a, b) => {
      let aValue = a[this.sortBy];
      let bValue = b[this.sortBy];

      if (this.sortOrder === 'asc') {
        return aValue - bValue;
      } else {
        return bValue - aValue;
      }
    });
  }

  changeSortBy(field: 'cases' | 'deaths' | 'recovered'): void {
    if (this.sortBy === field) {
      this.sortOrder = this.sortOrder === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortBy = field;
      this.sortOrder = 'desc';
    }
    this.sortCountries();
  }

  formatNumber(num: number | undefined): string {
    if (!num) return '0';
    return num.toLocaleString();
  }
}

