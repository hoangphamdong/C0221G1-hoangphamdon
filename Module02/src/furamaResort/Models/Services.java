package furamaResort.Models;

/**Tất cả các dịch vụ này sẽ bao có các thông tin:
 * Tên dịch vụ, Diện tích sử dụng, Chi phí thuê,
 * Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm,
 * tháng, ngày, giờ).
 */
public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double areaUse;
    protected double renCost;
    protected int numberOfPeoples;
    protected String typeRent;

    public Services() {
    }

    public Services(String id, String serviceName, double areaUse, double renCost, int numberOfPeoples, String typeRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.renCost = renCost;
        this.numberOfPeoples = numberOfPeoples;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRenCost() {
        return renCost;
    }

    public void setRenCost(double renCost) {
        this.renCost = renCost;
    }

    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setNumberOfPeoples(int numberOfPeoples) {
        this.numberOfPeoples = numberOfPeoples;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areaUse=" + areaUse +
                ", renCost=" + renCost +
                ", numberOfPeoples=" + numberOfPeoples +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }

    public abstract void showInFor();

}
