package com.example.erzhena.weather.models;

public class WeatherList {
    private int dt;
    private Object rain;
    private WeatherListCoord coord;
    private Object snow;
    private String name;
    private WeatherListWeather[] weather;
    private WeatherListMain main;
    private int id;
    private WeatherListClouds clouds;
    private WeatherListSys sys;
    private WeatherListWind wind;

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Object getRain() {
        return this.rain;
    }

    public void setRain(Object rain) {
        this.rain = rain;
    }

    public WeatherListCoord getCoord() {
        return this.coord;
    }

    public void setCoord(WeatherListCoord coord) {
        this.coord = coord;
    }

    public Object getSnow() {
        return this.snow;
    }

    public void setSnow(Object snow) {
        this.snow = snow;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherListWeather[] getWeather() {
        return this.weather;
    }

    public void setWeather(WeatherListWeather[] weather) {
        this.weather = weather;
    }

    public WeatherListMain getMain() {
        return this.main;
    }

    public void setMain(WeatherListMain main) {
        this.main = main;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeatherListClouds getClouds() {
        return this.clouds;
    }

    public void setClouds(WeatherListClouds clouds) {
        this.clouds = clouds;
    }

    public WeatherListSys getSys() {
        return this.sys;
    }

    public void setSys(WeatherListSys sys) {
        this.sys = sys;
    }

    public WeatherListWind getWind() {
        return this.wind;
    }

    public void setWind(WeatherListWind wind) {
        this.wind = wind;
    }
}
