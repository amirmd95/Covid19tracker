# COVID-19 Tracker - API Documentation

## Base URL
```
http://localhost:8080/api/covid19
```

## Endpoints

### 1. Get Global Statistics

**Endpoint:** `GET /global`

**Description:** Retrieves global COVID-19 statistics

**Response:**
```json
{
  "id": 1,
  "cases": 704753890,
  "todayCases": 15234,
  "deaths": 7010681,
  "todayDeaths": 123,
  "recovered": 675619811,
  "todayRecovered": 12456,
  "active": 22123398,
  "critical": 41156,
  "casesPerOneMillion": 90331,
  "deathsPerOneMillion": 899,
  "recoveredPerOneMillion": 86596,
  "criticalPerOneMillion": 5.3,
  "tests": 7045052423,
  "testsPerOneMillion": 903107,
  "population": 7800000000,
  "affectedCountries": 230,
  "updatedAt": "2024-01-15T10:30:00"
}
```

---

### 2. Get All Countries Statistics

**Endpoint:** `GET /countries`

**Description:** Retrieves COVID-19 statistics for all countries

**Response:**
```json
[
  {
    "id": 1,
    "country": "USA",
    "countryCode": "US",
    "cases": 103436829,
    "todayCases": 1234,
    "deaths": 1127152,
    "todayDeaths": 45,
    "recovered": 100620208,
    "todayRecovered": 1000,
    "active": 1689469,
    "critical": 1563,
    "casesPerOneMillion": 310584,
    "deathsPerOneMillion": 3384,
    "tests": 1152127078,
    "testsPerOneMillion": 3460714,
    "population": 333287557,
    "updatedAt": "2024-01-15T10:30:00",
    "flagUrl": "https://disease.sh/assets/img/flags/us.png"
  },
  // ... more countries
]
```

---

### 3. Get Country Statistics

**Endpoint:** `GET /countries/{country}`

**Description:** Retrieves COVID-19 statistics for a specific country

**Parameters:**
- `country` (path parameter) - Country name (e.g., "USA", "India", "UK")

**Example:**
```
GET /countries/USA
```

**Response:**
```json
{
  "id": 1,
  "country": "USA",
  "countryCode": "US",
  "cases": 103436829,
  "todayCases": 1234,
  "deaths": 1127152,
  "todayDeaths": 45,
  "recovered": 100620208,
  "todayRecovered": 1000,
  "active": 1689469,
  "critical": 1563,
  "casesPerOneMillion": 310584,
  "deathsPerOneMillion": 3384,
  "tests": 1152127078,
  "testsPerOneMillion": 3460714,
  "population": 333287557,
  "updatedAt": "2024-01-15T10:30:00",
  "flagUrl": "https://disease.sh/assets/img/flags/us.png"
}
```

---

### 4. Get Top Countries by Cases

**Endpoint:** `GET /countries/top/cases`

**Description:** Retrieves top countries sorted by total cases

**Query Parameters:**
- `limit` (optional, default: 10) - Number of countries to return

**Example:**
```
GET /countries/top/cases?limit=5
```

**Response:**
```json
[
  {
    "id": 1,
    "country": "USA",
    "cases": 103436829,
    // ... other fields
  },
  // ... more countries
]
```

---

### 5. Get Top Countries by Deaths

**Endpoint:** `GET /countries/top/deaths`

**Description:** Retrieves top countries sorted by total deaths

**Query Parameters:**
- `limit` (optional, default: 10) - Number of countries to return

**Example:**
```
GET /countries/top/deaths?limit=5
```

---

### 6. Get Top Countries by Recovered

**Endpoint:** `GET /countries/top/recovered`

**Description:** Retrieves top countries sorted by total recovered cases

**Query Parameters:**
- `limit` (optional, default: 10) - Number of countries to return

**Example:**
```
GET /countries/top/recovered?limit=5
```

---

### 7. Refresh Data

**Endpoint:** `POST /refresh`

**Description:** Manually triggers a refresh of COVID-19 data from the external API

**Example:**
```
POST /refresh
```

**Response:**
```
Data refresh initiated
```

---

## Error Responses

### External API Error (502 Bad Gateway)
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 502,
  "error": "External API Error",
  "message": "Failed to fetch data from COVID-19 API"
}
```

### Internal Server Error (500)
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "An unexpected error occurred"
}
```

---

## Data Updates

- Data is automatically refreshed every hour
- Manual refresh can be triggered using the `/refresh` endpoint
- Cached data expires after 1 hour

---

## CORS Configuration

Allowed origins:
- `http://localhost:4200` (Angular development server)
- `http://localhost:80` (Production)

---

## Health Check

**Endpoint:** `GET /actuator/health`

**Response:**
```json
{
  "status": "UP"
}
```

---

## Additional Endpoints

- `/actuator/info` - Application information
- `/actuator/metrics` - Application metrics
- `/h2-console` - H2 Database console (development only)

