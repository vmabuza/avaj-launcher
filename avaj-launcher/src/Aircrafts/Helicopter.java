package Aircrafts;

import Weather.*;
import Interface.*;
import Write.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

        String weatherType = weatherTower.getWeather(this.coordinates);
        String regToFile = "";
        String unregToFile = "";
        String temp = "Helicopter#" + this.name + "(" + this.id + "): ";

        if(weatherType == "RAIN"){
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
            regToFile = temp + "This rain is depressing...\n";
        }
        else if(weatherType == "SUN") {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 10,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 2);
            regToFile = temp + "It is extremely hot...\n";
        }
        else if(weatherType == "FOG") {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
            regToFile = temp + "It is too foggy...\n";
        }
        else if(weatherType == "SNOW") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 12);
            regToFile = temp + "Winter has arrived...\n";
        }

        WriteToFile.getWriteFile().writingToFile(regToFile);

        if(this.coordinates.getHeight() < 0) {
            unregToFile = "Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
            WriteToFile.getWriteFile().writingToFile(unregToFile);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        String write = "Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
        weatherTower.register(this);
        WriteToFile.getWriteFile().writingToFile(write);
    }
}