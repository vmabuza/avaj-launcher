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


        try {
            if(args.length == 0) {
                System.out.println("Invalid input");
                System.exit(1);
                //return;
            }
            BufferedReader reader = new BufferedReader(new FileReader("scenario.txt"));

            String line = reader.readLine();

            if (line != null) {

                weatherTower = new WeatherTower();

                int simulations = Integer.parseInt(line.split(" ")[0]);

                if (simulations < 0) {
                    System.out.println("Invalid simulation count can't be negative  ");
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {


                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));

                    if (flyable != null)
                        aircraftList.add(flyable);
                }
                WeatherTower write = new WeatherTower();

                for (Flyable flyable : aircraftList ) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    write.writeToFile("\n"+"count" + i);
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + args[0]);
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You did not specify the simulation file");
        } catch (NullPointerException e) {
            System.out.println("value is null");
        } catch (NumberFormatException e) {
            System.out.println("not a valid number entered in file");
        } finally {
//            WriteFile.getWriteFile().close();
        }
    }
}
