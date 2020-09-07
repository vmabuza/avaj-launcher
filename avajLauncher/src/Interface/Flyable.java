package com.vmabuza.avajLauncher.Interface;

import com.vmabuza.avajLauncher.Weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}