package model;

/**
 * Thông tin hóa đơn gồm có: Mã hóa đơn, Mã khách hàng,
 * ngày ra hoá đơn (ngày, tháng, năm),
 * số lượng (số KW tiêu thụ), đơn giá, thành tiền.
 */
public class InformationBill {
    private String codeBill;
    private String codeCustomer;
    private String dateBill;
    private double amount;
    private double unitPrice;
    private double intoMoney;

    public InformationBill() {
    }

    public InformationBill(String codeBill, String codeCustomer, String dateBill, double amount, double unitPrice, double intoMoney) {
        this.codeBill = codeBill;
        this.codeCustomer = codeCustomer;
        this.dateBill = dateBill;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.intoMoney = intoMoney;
    }

    public String getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(String codeBill) {
        this.codeBill = codeBill;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getDateBill() {
        return dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(double intoMoney) {
        this.intoMoney = intoMoney;
    }

    @Override
    public String toString() {
        return codeBill+","+codeCustomer+","+dateBill+","+unitPrice+","+intoMoney;
    }
    public  void showInfo(){
        System.out.println(this.toString());
    }
}
