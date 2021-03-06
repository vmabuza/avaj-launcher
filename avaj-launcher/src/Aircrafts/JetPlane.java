package Aircrafts;

import Weather.*;
import Interface.*;
import Write.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

        String weatherType = weatherTower.getWeather(this.coordinates);
        String regToFile = "";
        String unregToFile = "";
        String temp = "JetPlane#" + this.name + "(" + this.id + "): ";

        if(weatherType == "RAIN"){
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight());
            regToFile = temp + "This rain is depressing...\n";
        }
        else if(weatherType == "SUN") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
            regToFile = temp + "It is extremely hot...\n";
        }
        else if(weatherType == "FOG") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight());
            regToFile = temp + "It is too foggy...\n";
        }
        else if(weatherType == "SNOW") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 7);
            regToFile = temp + "Winter has arrived...\n";
        }

        WriteToFile.getWriteFile().writingToFile(regToFile);

        if(this.coordinates.getHeight() < 0) {
            unregToFile = "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
            WriteToFile.getWriteFile().writingToFile(unregToFile);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String write = "Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
        this.weatherTower = weatherTower;
        WriteToFile.getWriteFile().writingToFile(write);
    }
}