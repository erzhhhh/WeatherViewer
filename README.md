# WeatherViewer

WeatherViewer is a simple Android app that shows current weather information for selected locations.  
It retrieves data from a public weather API and displays it in a clean, minimal UI.

---

## What it does

- Search for a city and view current weather  
- Show temperature, conditions, humidity, and wind  
- Save locations to view later  
- Refresh data on demand

This project was created as a learning exercise to practice REST API calls, JSON parsing, and building basic Android interfaces.

---

## Main features

- Current weather fetched from an external API  
- List of saved cities  
- Basic network error handling  
- Lightweight structure — simple to read and extend

---

## Tech stack

- **Kotlin / Java** (depending on module)  
- **Android SDK** + classic View components  
- **HTTP client** (OkHttp/HttpURLConnection)  
- **JSON parsing**  
- **Gradle** build system

---

## Getting started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/erzhhhh/WeatherViewer.git
   cd WeatherViewer
   ```

2. **Open the project in Android Studio**

3. **Get an API key** from a weather provider (for example: OpenWeatherMap)

4. **Add the key** into configuration (e.g., `local.properties` or directly in code):
   ```properties
   WEATHER_API_KEY=YOUR_API_KEY
   ```

5. **Build and run** on an emulator or device.

---

## Project structure

```
WeatherViewer/
├── app/
│   ├── src/main/
│   │   ├── java/…      # App source code
│   │   ├── res/…       # Layouts & resources
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── settings.gradle
```

---

## Ideas for improvement

- Add multi-day forecast  
- Dark mode  
- Offline caching  
- Modern UI (Material 3 / Jetpack Compose)  
- Unit tests for networking layer
