package com.example.openweatherapi.models;

public class DataModel {
    private String main;
    private String description;
    private String icon;
    private double temp;
    private double feelTemp;
    private double minTemp;
    private double maxTemp;
    private int pressure;
    private int humidity;
    private double wind;
    private String date;
    private String name;

    public DataModel(String main, String description, String icon, double temp, double feelTemp, double minTemp, double maxTemp, int pressure, int humidity, double wind, String date, String name) {
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.temp = temp;
        this.feelTemp = feelTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
        this.date = date;
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelTemp() {
        return feelTemp;
    }

    public void setFeelTemp(double feelTemp) {
        this.feelTemp = feelTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
