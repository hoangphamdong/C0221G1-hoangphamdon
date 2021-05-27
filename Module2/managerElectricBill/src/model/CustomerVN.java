package model;

/**
 * + Khách hàng Việt Nam: mã khách hàng, họ tên,
 * loại khách hàng (sinh hoạt, kinh doanh, sản xuất), định mức tiêu thụ.
 */
public class CustomerVN extends Customer {
    private String customerType;
    private double consumptionNorms;

    public CustomerVN() {
    }

    public CustomerVN(String customerType, double consumptionNorms) {
        this.customerType = customerType;
        this.consumptionNorms = consumptionNorms;
    }

    public CustomerVN(String customerCode, String customerName, String customerType, double consumptionNorms) {
        super(customerCode, customerName);
        this.customerType = customerType;
        this.consumptionNorms = consumptionNorms;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getConsumptionNorms() {
        return consumptionNorms;
    }

    public void setConsumptionNorms(double consumptionNorms) {
        this.consumptionNorms = consumptionNorms;
    }

    @Override
    public String toString() {
        return super.toString()+","+customerType+","+consumptionNorms;
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
