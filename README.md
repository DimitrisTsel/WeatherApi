# Maven Java Weather API Project

## Overview
This project is an application implemented for the purpose of the course: **Java Programming Language** during my **MSc in Advanced Information Systems**.
It is Maven Java project provides functionalities to interact with weather data using the OpenWeather API. It includes methods to retrieve current weather, daily and hourly forecasts, based on location or IP address.
You can also browse the [user-manual](https://github.com/DimitrisTsel/WeatherApp/blob/master/manual-weatherApp.pdf) (in greek).

## Project Structure
The project structure is as follows:
- `src/main/java/com/weatherApi`: Contains the main Java classes for interacting with the OpenWeather API.
  - `CallWeatherApi.java`: Main class containing methods to retrieve weather data.
- `src/main/java/com/Coordinations`, `src/main/java/com/Current`, `src/main/java/com/Daily`, `src/main/java/com/Hourly`, `src/main/java/com/IPAddress`: Contains supporting classes for data deserialization.
- `pom.xml`: Maven project configuration file.

## Dependencies
This project utilizes the following dependencies:
- Apache HttpClient: For making HTTP requests to the OpenWeather API.
- Jackson Core and Jackson Databind: For JSON data serialization and deserialization.

## Installation
1. Clone the repository:
`git clone https://github.com/DimitrisTsel/weather-api.git`
2. Navigate to the project directory: `cd weather-api`
3. Build the project using Maven: `mvn clean install`


## Usage
- Import the `CallWeatherApi` class into your Java application.
- Use the provided methods to retrieve weather data:
- `getCurrentApi(String location, String type)`: Retrieve current weather data by location and temperature unit (e.g., metric, imperial).
- `getCurrentForecastUsingIp(String type)`: Retrieve current weather data based on the user's IP address and temperature unit.
- `getDailyApi(String location, String type)`: Retrieve daily weather forecast by location and temperature unit.
- `getDailyForecastUsingIp(String type)`: Retrieve daily weather forecast based on the user's IP address and temperature unit.
- `getHourlyApi(String location, String type)`: Retrieve hourly weather forecast by location and temperature unit.
- `getHourlyForecastUsingIp(String type)`: Retrieve hourly weather forecast based on the user's IP address and temperature unit.

## Configuration
- Replace the `OpenWeatherApiKey` and `AccessIPkey` constants in the `CallWeatherApi` class with your own API keys.
- Ensure proper network connectivity to access the OpenWeather API.

