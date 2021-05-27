package managerVehicle.commons;

import managerVehicle.models.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoFile {
    private static final String PATH="src/managerVehicle/data/";
    private static final String CSV=".csv";
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void writeFile(String fileName, List<Vehicle> list,boolean writeStatus){
        File file =new File(PATH+fileName+CSV);

        try {
            bufferedWriter=new BufferedWriter(new FileWriter(file,writeStatus));
            for (Vehicle vehicle:list){
                bufferedWriter.write(vehicle.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error in writing..!");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }public static List<String> readFile(String fileName){

        List<String> vehicleList=new ArrayList<>();

        File file=new File(PATH+fileName+CSV);

        try {
            if(!file.exists()){
                file.createNewFile();
            }
            bufferedReader=new BufferedReader(new FileReader(file));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                vehicleList.add(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in writing..!");
            e.printStackTrace();
        }return vehicleList;
    }


}
