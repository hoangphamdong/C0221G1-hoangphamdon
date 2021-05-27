package managerVehicle.models;

/**
 * Ôtô có thêm các thuộc tính : Số chỗ ngồi,
 * kiểu xe (du lịch, xe khách).
 */
public class Car extends Vehicle {
    private int numberOfSeats;
    private String vehicleModel;

    public Car() {
    }

    public Car(int numberOfSeats, String vehicleModel) {
        this.numberOfSeats = numberOfSeats;
        this.vehicleModel = vehicleModel;
    }

    public Car(String seaControl, String manufactureName, int yearOfManufacture, String owner, int numberOfSeats, String vehicleModel) {
        super(seaControl, manufactureName, yearOfManufacture, owner);
        this.numberOfSeats = numberOfSeats;
        this.vehicleModel = vehicleModel;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
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
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
