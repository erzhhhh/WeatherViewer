package com.example.erzhena.weather.models;

public class WeatherListMain {
    private double temp;
    private double temp_min;
    private int humidity;
    private int pressure;
    private double temp_max;

    public double getTemp() {
        return this.temp/10;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return this.temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return this.pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp_max() {
        return this.temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}
