package Interface;

import Weather.*;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}