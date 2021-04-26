package FuramaResort.Models;

public class House extends Services {
    private String standardRoom;
    private String convenient;
    private int numberOfFloors;

    public House() {
    }

    public House(String standardRoom, String convenient, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String ID, String servicesName, String areaUsed, double rentalCosts, int maximumPeople, String rentalType, String standardRoom, String convenient, int numberOfFloors) {
        super(ID, servicesName, areaUsed, rentalCosts, maximumPeople, rentalType);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInFor() {
        return null;
    }
}
