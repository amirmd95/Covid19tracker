# Quick Start Guide

## Option 1: Automated Setup (Recommended)

### For Mac/Linux:
```bash
./setup.sh
```

### For Windows:
```cmd
setup.bat
```

After setup completes:
1. Open two terminal windows
2. In Terminal 1 (Backend):
   ```bash
   cd backend
   mvn spring-boot:run
   ```
3. In Terminal 2 (Frontend):
   ```bash
   cd frontend
   npm start
   ```

## Option 2: Manual Setup

### Backend Setup
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend Setup (in a new terminal)
```bash
cd frontend
npm install
npm start
```

## Option 3: Docker Setup

```bash
docker-compose up --build
```

This will start:
- PostgreSQL on port 5432
- Backend on port 8080
- Frontend on port 80

## Access the Application

- **Frontend**: http://localhost:4200 (or http://localhost if using Docker)
- **Backend API**: http://localhost:8080/api/covid19
- **H2 Console** (development): http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:covid19_db`
  - Username: `sa`
  - Password: (empty)

## Test the API

### Get Global Statistics
```bash
curl http://localhost:8080/api/covid19/global
```

### Get All Countries
```bash
curl http://localhost:8080/api/covid19/countries
```

### Get Specific Country
```bash
curl http://localhost:8080/api/covid19/countries/USA
```

### Get Top Countries by Cases
```bash
curl http://localhost:8080/api/covid19/countries/top/cases
```

### Refresh Data
```bash
curl -X POST http://localhost:8080/api/covid19/refresh
```

## Troubleshooting

### Port Already in Use

**Backend (8080)**:
- Change port in `backend/src/main/resources/application.properties`
  ```properties
  server.port=8081
  ```

**Frontend (4200)**:
- Start with custom port:
  ```bash
  ng serve --port 4201
  ```

### CORS Issues
- Ensure backend is running
- Check `cors.allowed.origins` in `application.properties` matches frontend URL

### Database Connection Issues
- If using PostgreSQL, ensure it's running
- For development, H2 in-memory database is used by default

### Node Modules Issues
```bash
cd frontend
rm -rf node_modules package-lock.json
npm install
```

### Maven Build Issues
```bash
cd backend
mvn clean
mvn install -U
```

## Development Tips

### Watch Mode (Auto-reload)

**Backend**: Spring Boot DevTools is included, it will auto-restart on changes

**Frontend**: Already in watch mode with `npm start`

### Debug Mode

**Backend**:
```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

**Frontend**: Use browser DevTools (F12)

## Production Build

### Backend
```bash
cd backend
mvn clean package
java -jar target/covid19-tracker-1.0.0.jar
```

### Frontend
```bash
cd frontend
npm run build
# Output will be in dist/ directory
```

## Next Steps

1. Explore the Dashboard at http://localhost:4200/dashboard
2. View Countries data at http://localhost:4200/countries
3. Check API endpoints at http://localhost:8080/api/covid19
4. View database at http://localhost:8080/h2-console

Enjoy tracking COVID-19 data! 🦠📊

