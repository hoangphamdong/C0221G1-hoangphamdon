package model;

/**
 * khánh hàng gồm :mã khách hàng,
 * họ tên
 */
public abstract class Customer {
    protected String customerCode;
    protected String customerName;

    public Customer() {
    }

    public Customer(String customerCode, String customerName) {
        this.customerCode = customerCode;
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return customerCode+","+customerName;
    }
    public abstract void ShowInfo();
}
