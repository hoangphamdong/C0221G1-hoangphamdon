package furamaResort.Models;

/**
 * Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền
 */
public class ExtraService {
    private String extraServiceName;
    private String unit;
    private double money;

    public ExtraService() {
    }

    public ExtraService(String extraServiceName, String unit, double money) {
        this.extraServiceName = extraServiceName;
        this.unit = unit;
        this.money = money;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ExtraService{" +
                "extraServiceName='" + extraServiceName + '\'' +
                ", unit='" + unit + '\'' +
                ", money=" + money +
                '}';
    }
}
