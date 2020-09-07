package Aircrafts;

import Interface.*;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
//        System.out.println("We're in Airfactory");

        if (type.toUpperCase().equals("HELICOPTER"))
            return new Helicopter(name, coordinates);
        else if (type.toUpperCase().equals("JETPLANE"))
            return new JetPlane(name,coordinates);
        else if (type.toUpperCase().equals("BALOON"))
            return new Baloon(name,coordinates);
        else
            return null;
    }
}