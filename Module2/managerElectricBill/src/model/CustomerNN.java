package model;

/**
 * Khách hàng nước ngoài: mã khách hàng, họ tên,
 * quốc tịch
 */
public class CustomerNN extends Customer {
    private String nationality;

    public CustomerNN() {
    }

    public CustomerNN(String nationality) {
        this.nationality = nationality;
    }

    public CustomerNN(String customerCode, String customerName, String nationality) {
        super(customerCode, customerName);
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString()+","+nationality;
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
