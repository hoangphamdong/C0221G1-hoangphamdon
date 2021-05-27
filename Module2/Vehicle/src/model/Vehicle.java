package model;

/**
 * phương tiện gồm các thông tin: Biển kiểm soát ,
 * tên hãng sản xuất, năm sản xuất, chủ sở hữu.
 */
public abstract class Vehicle {
    protected String seaControl;
    protected String manufactureName;
    protected int manufactureYear;
    protected String owner;

    public Vehicle() {
    }

    public Vehicle(String seaControl, String manufactureName, int manufactureYear, String owner) {
        this.seaControl = seaControl;
        this.manufactureName = manufactureName;
        this.manufactureYear = manufactureYear;
        this.owner = owner;
    }

    public String getSeaControl() {
        return seaControl;
    }

    public void setSeaControl(String seaControl) {
        this.seaControl = seaControl;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return seaControl+","+manufactureName+","+manufactureYear+","+owner;

    }
    public abstract void showInfo();
}
