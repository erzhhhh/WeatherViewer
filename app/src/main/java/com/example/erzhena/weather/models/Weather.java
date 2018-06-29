package com.example.erzhena.weather.models;

public class Weather {
    private int count;
    private String cod;
    private String message;
    private WeatherList[] list;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WeatherList[] getList() {
        return this.list;
    }

    public void setList(WeatherList[] list) {
        this.list = list;
    }
}
