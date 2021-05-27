package furamaResort.Models;

/**-	Riêng Villa sẽ có thêm thông tin:
 * Tiêu chuẩn phòng, Mô tả tiện nghi khác, Diện tích hồ bơi, Số tầng.
 */
public class Villa  extends Services{
    private String standardRoom;
    private String otherDescription;
    private String areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standardRoom, String otherDescription, String areaPool, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String id, String serviceName, double areaUse, double renCost, int numberOfPeoples, String typeRent, String standardRoom, String otherDescription, String areaPool, int numberOfFloors) {
        super(id, serviceName, areaUse, renCost, numberOfPeoples, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.areaPool = areaPool;
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
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", areaPool='" + areaPool + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}'+super.toString();
    }

    @Override
    public void showInFor() {
        System.out.println(this.toString());
    }
}
