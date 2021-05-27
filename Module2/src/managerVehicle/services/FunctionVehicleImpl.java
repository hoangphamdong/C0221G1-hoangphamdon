package managerVehicle.services;

import managerVehicle.commons.IoFile;
import managerVehicle.exception.SeaControlException;
import managerVehicle.models.Car;
import managerVehicle.models.Truck;
import managerVehicle.models.Vehicle;
import managerVehicle.models.motorcycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionVehicleImpl implements functionVehicle {
    private static Scanner input = new Scanner(System.in);
    private boolean isBackToMenu;
    private static final String TRUCK = "xeTai";
    private static final String CAR = "oto";
    private static final String MOTORCYCLE = "xeMay";

    @Override
    public void addNewVehicle() {
        int choose = 0;
        do {
            System.out.println("Menu Add New Services:\n" +
                    "1.\tThêm xe Tải\n" +
                    "2.\tThêm xe oto\n" +
                    "3.\tThêm xe máy\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit. ");
            System.out.println("Enter Your Choose:");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNew(TRUCK);
                    isBackToMenu = false;
                    break;
                case 2:
                    addNew(CAR);
                    isBackToMenu = false;
                    break;
                case 3:
                    addNew(MOTORCYCLE);
                    isBackToMenu = false;
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
            if (isBackToMenu) {
                return;
            }
        } while (choose >= 1 && choose <= 5);

    }

    public static void addNew(String fileName) {
        List<Vehicle> vehicles = new ArrayList<>();

        input.nextLine();
        System.out.println("Please input sea control:");
        String seaControl = input.nextLine();

        input.nextLine();
        System.out.println("Please input manufacture Name:");
        String manufactureName = input.nextLine();

        System.out.println("Please input year of manufacture:");
        int yearOfManufacture = input.nextInt();

        input.nextLine();
        System.out.println("Please input owner:");
        String owner = input.nextLine();

        if (fileName.equals(TRUCK)) {
            System.out.println("Please input payload");
            double payload = input.nextDouble();

            Vehicle vehicle = new Truck(seaControl, manufactureName, yearOfManufacture, owner, payload);
            vehicles.add(vehicle);

            IoFile.writeFile(TRUCK, vehicles, false);
        } else if (fileName.equals(CAR)) {
            System.out.println("Please input number of seats");
            int numberOfSeats = input.nextInt();

            input.nextLine();
            System.out.println("Please input vehicle models:");
            String vehicleModels = input.nextLine();

            Vehicle vehicle = new Car(seaControl, manufactureName, yearOfManufacture, owner, numberOfSeats, vehicleModels);
            vehicles.add(vehicle);

            IoFile.writeFile(CAR, vehicles, false);
        } else if (fileName.equals(MOTORCYCLE)) {
            System.out.println("Please input wattage:");
            int wattage = input.nextInt();

            Vehicle vehicle = new motorcycle(seaControl, manufactureName, yearOfManufacture, owner, wattage);
            vehicles.add(vehicle);

            IoFile.writeFile(MOTORCYCLE, vehicles, false);
        }

    }

    @Override
    public void showVehicle() {
        int choose = 0;
        do {
            System.out.println("Menu Add New Services:\n" +
                    "1.\tHiển thị xe Tải\n" +
                    "2.\tHiển thị xe oto\n" +
                    "3.\tHiển thị xe máy\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit. ");
            System.out.println("Enter Your Choose:");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    showAllVehicle(TRUCK);
                    isBackToMenu = false;
                    break;
                case 2:
                    showAllVehicle(CAR);
                    isBackToMenu = false;
                    break;
                case 3:
                    showAllVehicle(MOTORCYCLE);
                    isBackToMenu = false;
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
            if (isBackToMenu) {
                return;
            }
        } while (choose >= 1 && choose <= 5);

    }

    public static List<Vehicle> showAll(String fileName) {
        List<String> propertiesVehicle = IoFile.readFile(fileName);

        List<Vehicle> vehicleOfList = new ArrayList<>();

        String[] propertiesElement = null;

        Vehicle vehicle = null;

        for (String properties : propertiesVehicle) {
            propertiesElement = properties.split(",");

            if (fileName.equals(TRUCK)) {

                vehicle = new Truck();
                ((Truck) vehicle).setPayload(Double.parseDouble(propertiesElement[4]));

            } else if (fileName.equals(CAR)) {

                vehicle = new Car();
                ((Car) vehicle).setNumberOfSeats(Integer.parseInt(propertiesElement[4]));
                ((Car) vehicle).setVehicleModel(propertiesElement[5]);

            } else if (fileName.equals(MOTORCYCLE)) {
                vehicle = new motorcycle();
                ((motorcycle) vehicle).setWattage(Integer.parseInt(propertiesElement[4]));

            }
            vehicle.setSeaControl(propertiesElement[0]);
            vehicle.setManufactureName(propertiesElement[1]);
            vehicle.setYearOfManufacture(Integer.parseInt(propertiesElement[2]));
            vehicle.setOwner(propertiesElement[3]);
            vehicleOfList.add(vehicle);

        }
        return vehicleOfList;
    }

    public static void showAllVehicle(String fileName) {
        System.out.println("---------------------------------");
        System.out.println("List......");
        for (Vehicle vehicle : showAll(fileName)) {
            vehicle.ShowInfo();
        }
    }

    @Override
    public void deleteVehicle(String seaControl,String fileName) throws SeaControlException {
        List<Vehicle>vehicleList=showAll(fileName);
        boolean isSeaControlNotFound=true;
        for(int i=0;i<vehicleList.size();i++){
            if(seaControl==vehicleList.get(i).getSeaControl()){
                vehicleList.remove(i);
                isSeaControlNotFound=false;
            }
            if(isSeaControlNotFound){
                throw new SeaControlException("dđhhđ");
            }
            IoFile.writeFile(CAR,vehicleList,false);
        }
    }


}
