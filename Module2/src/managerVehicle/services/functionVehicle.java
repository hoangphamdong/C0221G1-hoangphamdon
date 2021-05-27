package managerVehicle.services;

import managerVehicle.exception.SeaControlException;
import managerVehicle.models.Vehicle;

import java.util.List;

public interface functionVehicle {
    void addNewVehicle();
    void showVehicle();
    void deleteVehicle(String seaControl,String fileName) throws SeaControlException;
}
