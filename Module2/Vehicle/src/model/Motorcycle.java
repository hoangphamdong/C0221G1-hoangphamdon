package model;

/**
 * Xe máy có thêm thuộc tính: Công suất.
 */
public class Motorcycle extends Vehicle {
    private int wattage;

    public Motorcycle() {
    }

    public Motorcycle(int wattage) {
        this.wattage = wattage;
    }

    public Motorcycle(String seaControl, String manufactureName, int manufactureYear, String owner, int wattage) {
        super(seaControl, manufactureName, manufactureYear, owner);
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
    public void showInfo() {
        System.out.println(this.toString());
    }
}
