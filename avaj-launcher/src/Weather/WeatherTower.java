package Weather;

import Aircrafts.*;

import java.io.*;
//import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class WeatherTower extends Tower {
    private static FileWriter fileWriter;
    private static File file;
    private static BufferedWriter bufferedWriter;

    public void writeToFile(String str) {
        try {

            file = new File("simulation.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println(str);

            bufferedWriter.newLine();
            bufferedWriter.write(str);
            bufferedWriter.close();
        }
        catch (IOException whatever) {
            return;
        }
    }

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