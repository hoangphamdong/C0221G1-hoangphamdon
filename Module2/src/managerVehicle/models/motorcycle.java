package managerVehicle.models;

/**
 * Xe máy có thêm thuộc tính: Công suất.
 */
public class motorcycle extends Vehicle{
private int wattage;

    public motorcycle() {
    }

    public motorcycle(int wattage) {
        this.wattage = wattage;
    }

    public motorcycle(String seaControl, String manufactureName, int yearOfManufacture, String owner, int wattage) {
        super(seaControl, manufactureName, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString()+","+wattage;
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
