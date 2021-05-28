package model;

public class Customer {
    String nameCustomer;
    String birthDateCustomer;
    String addressCustomer;
    String imgCustomer;

    public Customer() {
    }

    public Customer(String name, String date, String address, String img) {
        this.nameCustomer = name;
        this.birthDateCustomer = date;
        this.addressCustomer = address;
        this.imgCustomer = img;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthDateCustomer() {
        return birthDateCustomer;
    }

    public void setBirthDateCustomer(String birthDateCustomer) {
        this.birthDateCustomer = birthDateCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getImgCustomer() {
        return imgCustomer;
    }

    public void setImgCustomer(String imgCustomer) {
        this.imgCustomer = imgCustomer;
    }

}

