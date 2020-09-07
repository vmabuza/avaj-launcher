package Weather;

import Aircrafts.Coordinates;

import java.io.IOException;

//import java.io.BufferedWriter;
public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather() {
        try {
            this.conditionsChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}