package managerVehicle.models;

/**
 * Xe tải  có thêm thuộc tính: Trọng tải.
 */
public class Truck extends Vehicle{
    private double payload;

    public Truck() {
    }

    public Truck(double payload) {
        this.payload = payload;
    }

    public Truck(String seaControl, String manufactureName, int yearOfManufacture, String owner, double payload) {
        super(seaControl, manufactureName, yearOfManufacture, owner);
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString()+","+payload;
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
