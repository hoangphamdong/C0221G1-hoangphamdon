package service;

import exception.SeaControlException;
import model.Vehicle;

import java.util.List;

public interface VehicleService {
    void addNewVehicle(String fileName);
    void showVehicle(String fileName);
    void delete(String seatControl,String fileName)throws SeaControlException;
}
