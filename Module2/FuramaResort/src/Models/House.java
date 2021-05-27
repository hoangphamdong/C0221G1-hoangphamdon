package Models;

public class House extends Services {
    private String roomStandard;
    private String describeUtilities;
    private int numberOfFloors;

    public House() {
    }

    public House(String roomStandard, String describeUtilities, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.describeUtilities = describeUtilities;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String id, String servicesName, double useArea, double rentalCosts, int maximumGuest, String rentalOption, String roomStandard, String describeUtilities, int numberOfFloors) {
        super(id, servicesName, useArea, rentalCosts, maximumGuest, rentalOption);
        this.roomStandard = roomStandard;
        this.describeUtilities = describeUtilities;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", describeUtilities='" + describeUtilities + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    @Override
    public String showInFor() {
        return "roomStandard "+getRoomStandard()
                +"describeUtilities "+getDescribeUtilities()
                +"numberOfFloors "+getNumberOfFloors();
    }
}
