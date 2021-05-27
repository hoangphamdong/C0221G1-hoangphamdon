package model;

/**
 * Ôtô có thêm các thuộc tính : Số chỗ ngồi, kiểu xe
 */

public class Car extends Vehicle {

    private String numberOfSeats;
    private String vehicleModel;

    public Car() {
    }

    public Car(String numberOfSeats, String vehicleModel) {
        this.numberOfSeats = numberOfSeats;
        this.vehicleModel = vehicleModel;
    }

    public Car(String seaControl, String manufactureName, int manufactureYear, String owner, String numberOfSeats, String vehicleModel) {
        super(seaControl, manufactureName, manufactureYear, owner);
        this.numberOfSeats = numberOfSeats;
        this.vehicleModel = vehicleModel;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public String toString() {
        return super.toString()+","+numberOfSeats+","+vehicleModel;
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
