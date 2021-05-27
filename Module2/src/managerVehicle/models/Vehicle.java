package managerVehicle.models;

/**
 * phương tiện gồm các thông tin: Biển kiểm soát ,
 * tên hãng sản xuất, năm sản xuất,
 * chủ sở hữu.
 */
public abstract class Vehicle {
    protected String seaControl;
    protected String manufactureName;
    protected int yearOfManufacture;
    protected String owner;

    public Vehicle() {
    }

    public Vehicle(String seaControl, String manufactureName, int yearOfManufacture, String owner) {
        this.seaControl = seaControl;
        this.manufactureName = manufactureName;
        this.yearOfManufacture = yearOfManufacture;
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

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return seaControl+","+manufactureName+","+yearOfManufacture+","+owner;
    }
    public abstract void ShowInfo();
}
