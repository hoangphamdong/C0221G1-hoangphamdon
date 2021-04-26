package FuramaResort.Models;

public class Villa extends Services {
    private String standardRoom;
    private String convenient;
    private String areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standardRoom, String convenient, String areaPool, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String ID, String servicesName, String areaUsed, double rentalCosts, int maximumPeople, String rentalType, String standardRoom, String convenient, String areaPool, int numberOfFloors) {
        super(ID, servicesName, areaUsed, rentalCosts, maximumPeople, rentalType);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.areaPool = areaPool;
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

    public String getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(String areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public  String showInFor() {
        return "Villa{"
                +getStandardRoom()+";"
                +getNumberOfFloors()+";"
                +getAreaPool()+";"
                +getConvenient()
                +"}";

    }
}
