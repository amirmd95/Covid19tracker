#!/bin/bash

echo "🦠 COVID-19 Tracker - Setup Script"
echo "=================================="
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 17 or higher."
    exit 1
fi

# Check if Node.js is installed
if ! command -v node &> /dev/null; then
    echo "❌ Node.js is not installed. Please install Node.js 18 or higher."
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed. Please install Maven 3.6 or higher."
    exit 1
fi

echo "✅ All prerequisites are installed"
echo ""

# Setup Backend
echo "📦 Setting up Backend..."
cd backend
mvn clean install -DskipTests
if [ $? -eq 0 ]; then
    echo "✅ Backend setup completed successfully"
else
    echo "❌ Backend setup failed"
    exit 1
fi
cd ..

echo ""

# Setup Frontend
echo "📦 Setting up Frontend..."
cd frontend
npm install
if [ $? -eq 0 ]; then
    echo "✅ Frontend setup completed successfully"
else
    echo "❌ Frontend setup failed"
    exit 1
fi
cd ..

echo ""
echo "🎉 Setup completed successfully!"
echo ""
echo "To start the application:"
echo "1. Start Backend:  cd backend && mvn spring-boot:run"
echo "2. Start Frontend: cd frontend && npm start"
echo ""
echo "Backend will be available at: http://localhost:8080"
echo "Frontend will be available at: http://localhost:4200"
echo ""

