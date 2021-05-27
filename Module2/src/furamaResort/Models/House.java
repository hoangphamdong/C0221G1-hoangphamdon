package furamaResort.Models;

/**
 * -Riêng House sẽ có thêm thông tin: Tiêu chuẩn phòng,
 * Mô tả tiện nghi khác, Số tầng.
 */
public class House extends Services {
    private String standardRoom;
    private String otherDescription;
    private int numberOfFloors;

    public House() {
    }

    public House(String standardRoom, String otherDescription, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String id, String serviceName, double areaUse, double renCost, int numberOfPeoples, String typeRent, String standardRoom, String otherDescription, int numberOfFloors) {
        super(id, serviceName, areaUse, renCost, numberOfPeoples, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
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
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}'+super.toString();
    }

    @Override
    public void showInFor() {
        System.out.println(this.toString());
    }
}
