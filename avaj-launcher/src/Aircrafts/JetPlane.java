package Aircrafts;

import Weather.*;
import Interface.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
//        System.out.println("We're in a Jetplane");
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

        weatherTower.writeToFile(regToFile);

        if(this.coordinates.getHeight() < 0) {
            unregToFile = "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
            weatherTower.writeToFile(unregToFile);
            weatherTower.unregister(this);
        }
    }


    @Override
    public void registerTower(WeatherTower weatherTower) {
        System.out.println("We're registering to tower");
        weatherTower.register(this);
        String write = "Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
        this.weatherTower = weatherTower;
        weatherTower.writeToFile(write);
    }
}