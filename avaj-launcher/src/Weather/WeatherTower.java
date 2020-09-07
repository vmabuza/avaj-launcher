package Weather;

import Aircrafts.*;

import java.io.*;
//import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class WeatherTower extends Tower {

    public void writeToFile(String str) {


        try {
            WriteFile writeFile = new WriteFile();
            File file = new File("simulation.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
            bufferedWrite.write(str);

            bufferedWrite.newLine();
        }
        catch (IOException whatever) {
            return;
        }
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather() {
        this.conditionsChanged();
    }

    private class WriteFile {
    }
}