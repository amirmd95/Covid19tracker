# COVID-19 Tracker Application

A full-stack COVID-19 tracking application built with Angular (frontend) and Spring Boot (backend) that displays real-time COVID-19 statistics from around the world.

## Features

- 📊 Global COVID-19 statistics dashboard
- 🌍 Country-wise COVID-19 data with search and sort functionality
- 🔄 Real-time data updates from disease.sh API
- 📱 Responsive design for mobile and desktop
- 🎨 Modern and intuitive user interface
- 🔍 Search countries by name
- 📈 Sort data by cases, deaths, and recoveries

## 🚀 Live Deployment

**Want to deploy this app and get a live link to share?**

📖 **See**: [`DEPLOY_NOW.md`](DEPLOY_NOW.md) for step-by-step deployment guide!

**Free hosting options**:
- ✅ **Vercel** (Frontend) + **Render** (Backend) - 100% FREE
- ✅ **Railway** - $5/month credit (free tier)
- ✅ **Netlify** (Frontend) + **Render** (Backend) - 100% FREE

**Get your live link in 20 minutes!** 🎉

All deployment configurations are included and ready to use.

## Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (development) / **PostgreSQL** (production)
- **WebClient** for external API calls
- **Lombok** for reducing boilerplate code
- **Maven** for dependency management

### Frontend
- **Angular 17**
- **TypeScript**
- **RxJS** for reactive programming
- **Angular Router** for navigation
- **HttpClient** for API communication

### External API
- **disease.sh** - COVID-19 statistics API

## Project Structure

```
Covid19tracker/
├── backend/                          # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/covid19/tracker/
│   │   │   │   ├── config/          # Configuration classes
│   │   │   │   ├── controller/      # REST controllers
│   │   │   │   ├── dto/             # Data Transfer Objects
│   │   │   │   ├── model/           # JPA entities
│   │   │   │   ├── repository/      # JPA repositories
│   │   │   │   ├── service/         # Business logic
│   │   │   │   └── Covid19TrackerApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   └── pom.xml
│
└── frontend/                         # Angular frontend
    ├── src/
    │   ├── app/
    │   │   ├── components/          # Angular components
    │   │   │   ├── dashboard/       # Dashboard component
    │   │   │   └── countries/       # Countries list component
    │   │   ├── models/              # TypeScript interfaces
    │   │   ├── services/            # Angular services
    │   │   ├── app.component.*      # Root component
    │   │   ├── app.config.ts        # App configuration
    │   │   └── app.routes.ts        # Routing configuration
    │   ├── environments/            # Environment configs
    │   ├── index.html
    │   ├── main.ts
    │   └── styles.css
    ├── angular.json
    ├── package.json
    └── tsconfig.json
```

## Installation & Setup

### Prerequisites
- Java 17 or higher
- Node.js 18+ and npm
- Maven 3.6+

### Backend Setup

1. Navigate to the backend directory:
```bash
cd backend
```

2. Install dependencies and build:
```bash
mvn clean install
```

3. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

#### Database Configuration

**H2 Database (Default - Development)**
- Access H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:covid19_db`
- Username: `sa`
- Password: (leave empty)

**PostgreSQL (Production)**

Uncomment the PostgreSQL configuration in `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/covid19_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The frontend will start on `http://localhost:4200`

## API Endpoints

### Backend REST API

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/covid19/global` | Get global COVID-19 statistics |
| GET | `/api/covid19/countries` | Get all countries statistics |
| GET | `/api/covid19/countries/{country}` | Get specific country statistics |
| GET | `/api/covid19/countries/top/cases` | Get top 10 countries by cases |
| GET | `/api/covid19/countries/top/deaths` | Get top 10 countries by deaths |
| GET | `/api/covid19/countries/top/recovered` | Get top 10 countries by recovered |
| POST | `/api/covid19/refresh` | Manually refresh COVID-19 data |

## Features in Detail

### Dashboard
- Displays global COVID-19 statistics including:
  - Total cases and today's cases
  - Total deaths and today's deaths
  - Total recovered and today's recovered
  - Active cases
  - Critical cases
  - Total tests conducted
  - Number of affected countries

### Countries View
- Lists all countries with COVID-19 data
- Search functionality to filter countries
- Sortable columns (cases, deaths, recovered)
- Displays country flags
- Shows detailed statistics per country

### Data Updates
- Automatic data refresh every hour
- Manual refresh option available
- Caching mechanism to reduce API calls

## Configuration

### Backend Configuration (`application.properties`)

```properties
# Server Port
server.port=8080

# Database (H2 for development)
spring.datasource.url=jdbc:h2:mem:covid19_db

# API Base URL
covid.api.base-url=https://disease.sh/v3/covid-19

# CORS
cors.allowed.origins=http://localhost:4200

# Cache (1 hour expiration)
spring.cache.caffeine.spec=expireAfterWrite=1h
```

### Frontend Configuration (`environment.ts`)

```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api/covid19'
};
```

## Development

### Running Tests

**Backend:**
```bash
cd backend
mvn test
```

**Frontend:**
```bash
cd frontend
npm test
```

### Building for Production

**Backend:**
```bash
cd backend
mvn clean package
java -jar target/covid19-tracker-1.0.0.jar
```

**Frontend:**
```bash
cd frontend
npm run build
```

The production build will be created in the `dist/` directory.

## Future Enhancements

- 📊 Add charts and graphs using Chart.js
- 🗺️ Interactive world map visualization
- 📅 Historical data trends
- 🔔 Notifications for significant changes
- 🌐 Multi-language support
- 📱 Progressive Web App (PWA) support
- 🔐 User authentication and favorites
- 📊 Vaccination statistics

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Acknowledgments

- Data provided by [disease.sh](https://disease.sh) - Open Disease Data API
- Built with Spring Boot and Angular
- Icons and design inspiration from various sources

## Contact

For any queries or suggestions, please open an issue on GitHub.

---

**Stay safe, stay informed!** 🦠💙
