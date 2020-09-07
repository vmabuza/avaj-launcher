package Aircrafts;

import Weather.*;
import Interface.*;

import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    public WeatherTower write = new WeatherTower();

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() throws IOException {
//        System.out.println("We're in a baloon");
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

//        weatherTower.writeToFile(regToFile);
        write.writeToFile("Eslkdlskd");
        write.writeToFile(regToFile);
        write.writeToFile("Hello world!");

        if(this.coordinates.getHeight() < 0) {
            unregToFile = "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
            weatherTower.writeToFile(unregToFile);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        weatherTower.register(this);
        String write = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
        this.weatherTower = weatherTower;
        weatherTower.writeToFile(write);
        System.out.println("We're registering to tower");
    }
}