package Weather;

import Aircrafts.*;

class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"FOG", "RAIN", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4];
    }
}
