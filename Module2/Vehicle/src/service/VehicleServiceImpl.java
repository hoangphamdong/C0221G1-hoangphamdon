package service;

import common.IoFile;
import common.StringUtil;
import common.Validate;
import exception.SeaControlEE;
import exception.SeaControlException;
import model.Car;
import model.Motorcycle;
import model.Truck;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleServiceImpl implements VehicleService {
    private static Scanner input = new Scanner(System.in);


    @Override
    public void addNewVehicle(String fileName) {
        Vehicle vehicle = null;
        List<Vehicle> vehicleList = new ArrayList<>();

        boolean flag=false;
        String seaControl = null;
        if (fileName.equals(StringUtil.TRUCK)) {
            do {
                flag = true;
                System.out.println("vui lòng nhập biển kiểm soát:");
                seaControl = input.nextLine();

                Validate.isValidRegex(seaControl, Validate.SEA_CONTROL_TRUCK_REGEX);
            } while (flag);
        } else if (fileName.equals(StringUtil.CAR)) {
            do {
                flag = true;
                System.out.println("vui lòng nhập biển kiểm soát:");
                seaControl = input.nextLine();
                Validate.isValidRegex(seaControl, Validate.SEA_CONTROL_CAR_REGEX);
            } while (flag);
        }else if (fileName.equals(StringUtil.MOTORCYCLE)) {
            do {
                flag = true;
                System.out.println("vui lòng nhập biển kiểm soát:");
                seaControl = input.nextLine();
                Validate.isValidRegex(seaControl, Validate.SEA_CONTROL_MOTORCYCLE_REGEX);
            } while (flag);
        }

        System.out.println("vui lòng nhập tên hãng sản xuất: ");
        String manufactureName = input.nextLine();

        System.out.println("vui lòng nhập năm sản xuất:");
        int manufactureYear = Integer.parseInt(input.nextLine());

        System.out.println("vui lòng nhập chủ sở hữu:");
        String owner = input.nextLine();

        if (fileName.equals(StringUtil.TRUCK)) {

            System.out.println("vui lòng nhập trọng tải:");
            int payload = Integer.parseInt(input.nextLine());

            vehicle = new Truck(seaControl, manufactureName, manufactureYear, owner, payload);
            vehicleList.add(vehicle);
            IoFile.writeFile(StringUtil.TRUCK, vehicleList, true);
        } else if (fileName.equals(StringUtil.CAR)) {

            System.out.println("vui lòng nhập số chỗ ngồi:");
            String numberOfSeats = input.nextLine();

            System.out.println("vui lòng nhập kiểu xe:");
            String vehicleModel = input.nextLine();

            vehicle = new Car(seaControl, manufactureName, manufactureYear, owner, numberOfSeats, vehicleModel);
            vehicleList.add(vehicle);
            IoFile.writeFile(StringUtil.CAR, vehicleList, true);

        } else if (fileName.equals(StringUtil.MOTORCYCLE)) {

            System.out.println("vui lòng nhập công xuất:");
            int wattage = Integer.parseInt(input.nextLine());

            vehicle = new Motorcycle(seaControl, manufactureName, manufactureYear, owner, wattage);
            vehicleList.add(vehicle);
            IoFile.writeFile(StringUtil.MOTORCYCLE, vehicleList, true);

        }


    }

    @Override
    public void showVehicle(String fileName) {
        List<Vehicle> vehicleList = IoFile.readFile(fileName);
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void delete(String seatControl, String fileName) throws SeaControlException {
        boolean seatControlNotFound = true;
        List<Vehicle> vehicleList = IoFile.readFile(fileName);
        for (int i = 0; i < vehicleList.size(); i++) {
            if (seatControl.equals(vehicleList.get(i).getSeaControl())) {
                vehicleList.remove(vehicleList.get(i));
                seatControlNotFound = false;
                break;
            }
        }
        if (seatControlNotFound) {
            throw new SeaControlException("sea control not found...!");
        }
        IoFile.writeFile(fileName, vehicleList, false);


    }

}
