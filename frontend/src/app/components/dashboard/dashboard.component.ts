import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GlobalStats } from '../../models/global-stats.model';
import { Covid19Service } from '../../services/covid19.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  globalStats: GlobalStats | null = null;
  loading = false;
  error: string | null = null;

  constructor(private covid19Service: Covid19Service) { }

  ngOnInit(): void {
    this.loadGlobalStats();
  }

  loadGlobalStats(): void {
    this.loading = true;
    this.error = null;
    this.covid19Service.getGlobalStats().subscribe({
      next: (data) => {
        this.globalStats = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load global statistics';
        this.loading = false;
        console.error(err);
      }
    });
  }

  formatNumber(num: number | undefined): string {
    if (!num) return '0';
    return num.toLocaleString();
  }

  refreshData(): void {
    this.covid19Service.refreshData().subscribe({
      next: () => {
        this.loadGlobalStats();
      },
      error: (err) => {
        console.error('Error refreshing data:', err);
      }
    });
  }
}

