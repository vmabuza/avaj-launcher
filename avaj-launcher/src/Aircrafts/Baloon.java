package Aircrafts;

import Weather.*;
import Interface.*;
import Write.*;

import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
//    public WeatherTower write = new WeatherTower();

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() throws IOException {

        String weatherType = weatherTower.getWeather(this.coordinates);
        String regToFile = "";
        String unregToFile = "";
        String temp = "Baloon#" + this.name + "(" + this.id + "): ";

        if(weatherType == "RAIN"){
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
            regToFile = temp + "This rain is depressing...\n";
        }
        else if(weatherType == "SUN") {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 4);
            regToFile = temp + "It is extremely hot...\n";
        }
        else if(weatherType == "FOG") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3);
            regToFile = temp + "It is too foggy...\n";
        }
        else if(weatherType == "SNOW") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
            regToFile = temp + "Winter has arrived...\n";
        }
        WriteToFile.getWriteFile().writingToFile(regToFile);
//        write.WriteFile(regToFile);

        if(this.coordinates.getHeight() < 0) {
            unregToFile = "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
            WriteToFile.getWriteFile().writingToFile(unregToFile);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        weatherTower.register(this);
        String write = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
        this.weatherTower = weatherTower;
        WriteToFile.getWriteFile().writingToFile(write);
    }
}