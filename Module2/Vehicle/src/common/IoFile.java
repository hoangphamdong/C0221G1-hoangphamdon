package common;

import model.Car;
import model.Motorcycle;
import model.Truck;
import model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoFile {
    private static final String PATH = "src/data/";
    private static final String CSV = ".csv";
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;

    public static void writeFile(String fileName, List<Vehicle> list, boolean writeStatus) {

        File file = new File(PATH + fileName + CSV);

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, writeStatus));
            for (Vehicle vehicle : list) {

                bufferedWriter.write(vehicle.toString());
                bufferedWriter.newLine();

            }

        } catch (IOException e) {

            System.out.println("Error in writing......!");
            e.printStackTrace();

        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static List<Vehicle> readFile(String fileName) {
        List<Vehicle> vehicleList = new ArrayList<>();
        File file = new File(PATH + fileName + CSV);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp = null;
            Vehicle vehicle = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                if (fileName.equals(StringUtil.TRUCK)) {
                    vehicle = new Truck(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]));
                } else if (fileName.equals(StringUtil.CAR)) {
                    vehicle = new Car(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4], temp[5]);
                } else if (fileName.equals(StringUtil.MOTORCYCLE)) {
                    vehicle = new Truck(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]));
                }
                vehicleList.add(vehicle);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error read file.....!");
            e.printStackTrace();
        }
        return vehicleList;
    }
}

