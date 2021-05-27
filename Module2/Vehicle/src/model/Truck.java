package model;

/**
 * Xe tải  có thêm thuộc tính: Trọng tải.
 */
public class Truck extends Vehicle {

    private int payload;

    public Truck() {
    }

    public Truck(int payload) {
        this.payload = payload;
    }

    public Truck(String seaControl, String manufactureName, int manufactureYear, String owner, int payload) {
        super(seaControl, manufactureName, manufactureYear, owner);
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString()+","+payload;
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
