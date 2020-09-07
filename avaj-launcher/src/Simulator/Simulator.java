package Simulator;

import Interface.*;
import Aircrafts.*;
import Weather.*;
import java.util.*;
import java.io.*;


public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> aircraftList = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        if(args.length == 0){
            System.out.println("Please pass an argument!");
            System.exit(1);
        }
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String str = reader.readLine();
        int sim = Integer.parseInt(str.split(" ")[0]);


            if (str != null) {

                weatherTower = new WeatherTower();


                if (sim <= 0) {
                    System.exit(1);
                }
            }
            while ((str = reader.readLine()) != null) {

              Flyable flyable =  AircraftFactory.newAircraft(str.split(" ")[0],str.split(" ")[1],Integer.parseInt(str.split(" ")[2]),Integer.parseInt(str.split(" ")[3]),Integer.parseInt(str.split(" ")[4]));
//              System.out.println(str.split(" ")[1]);
//              System.out.println(flyable);

              if(flyable != null){
                  aircraftList.add(flyable);
              }
            }
            for (Flyable flyable : aircraftList) {
                flyable.registerTower(weatherTower);
//                System.out.println("Yeah we're winning");
//                System.out.println();
            }

            for (int i = 1; i <= sim; i++) {
                String simToWrite = "\nSimulation: " + i + "\n";
                weatherTower.writeToFile(simToWrite);
                weatherTower.changeWeather();
            }
            reader.close();
    }
}
