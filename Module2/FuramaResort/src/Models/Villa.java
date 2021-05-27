package Models;

public class Villa extends Services {
    private String roomStandard;
    private String describeUtilities;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String roomStandard, String describeUtilities, double areaPool, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.describeUtilities = describeUtilities;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String id, String servicesName, double useArea, double rentalCosts, int maximumGuest, String rentalOption, String roomStandard, String describeUtilities, double areaPool, int numberOfFloors) {
        super(id, servicesName, useArea, rentalCosts, maximumGuest, rentalOption);
        this.roomStandard = roomStandard;
        this.describeUtilities = describeUtilities;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescribeUtilities() {
        return describeUtilities;
    }

    public void setDescribeUtilities(String describeUtilities) {
        this.describeUtilities = describeUtilities;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ","+
                roomStandard +
                "," + describeUtilities +
                "," + areaPool +
                "," + numberOfFloors ;
    }

    @Override
    public String showInFor() {
        return "roomStandard "+getRoomStandard()
                +"describeUtilities "+getDescribeUtilities()
                +"areaPool "+getAreaPool()
                +"numberOfFloors "+getNumberOfFloors();
    }
}
