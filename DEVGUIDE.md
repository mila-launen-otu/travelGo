# Developer Guide for Travel Package Management Application

## Introduction
This document provides an overview of the Travel Package Management Application from a development perspective. It includes system architecture, key functionalities, and instructions on extending and maintaining the application.

## Technologies Used
- Frontend: javafx
- 

## Project Structure
```
travelGo/
│── src/main
│   ├── java/
|      ├──module-info.java
|      ├──travelgogui
|          ├──login_screen
|              ├──LoginController.java
|              ├──LoginInteractor.java
|              ├──LoginModel.java
|              ├──LoginViewBuilder.java
|              ├──functionalInterface.java
|          ├──main
|              ├──MainController.java
|              ├──MainModel.java
|              ├──MainViewBuilder.java
|          ├──travel_database_screen
|              ├──TravelDatabaseController.java
|              ├──TravelDatabaseInteractor.java
|              ├──TravelDatabasenModel.java
|              ├──TravelDatabaseViewBuilder.java
|              ├──TravelDatabaseDetailView.java
|              ├──components
|                ├──TravelPackageDialogs.java
|              ├──backend
|                ├──TravelDatabase.java
|                ├──TravelPackage.java
|                ├──TravelPackageList.java
|          ├──MainApplication.java
│   ├── resources/images
|        ├── alex-azabache-V83v-MYB_Z8-unsplash.jpg
|        ├── default.jpg
│── .mvn/wrapper
│   ├── components/
│   ├── pages/
│   ├── App.js
│── README.md
│── pom.xml
│── travel_packages.xml
```

## Setup Instructions
1. **Clone the repository**
   ```sh
   https://github.com/mila-launen-otu/travelGo.git
   cd travelGo
   ```
2. **Install dependencies**
   ```sh
   cd backend && npm install
   cd ../frontend && npm install
   ```
3. **Run the application**
   ```sh
   # Start backend
   cd backend
   npm start
   
   # Start frontend
   cd ../frontend
   npm start
   ```

## API Endpoints
### Authentication
- **POST** `/api/auth/login` - Logs in a user and returns a JWT token
- **POST** `/api/auth/register` - Registers a new user

### Travel Packages
- **GET** `/api/packages` - Retrieve all travel packages
- **POST** `/api/packages` - Add a new travel package (Admin only)
- **PUT** `/api/packages/:id` - Update a travel package (Admin only)
- **DELETE** `/api/packages/:id` - Remove a travel package (Admin only)

## Filtering Logic
Users can filter travel packages based on:
- **Region**
- **Price Range** (min/max price)
- **Stock Availability** (min/max stock)

Filtering is handled via query parameters:
```sh
GET /api/packages?region=Europe&minPrice=1000&maxPrice=5000&minStock=5
```

## Conclusion
This guide provides an overview of the development and extension of the Travel Package Management Application. For contributions, submit a pull request to the repository. Happy coding!
