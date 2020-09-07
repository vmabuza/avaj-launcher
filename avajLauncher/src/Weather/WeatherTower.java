package com.vmabuza.avajLauncher.Weather;

import com.vmabuza.avajLauncher.Aircrafts.Coordinates;

public class WeatherTower extends Tower {
    public static String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather() {
        super.conditionsChanged();
    }
}