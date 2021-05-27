package product.models;

public class Product {
    private int id;
    private String productName;
    private double productAmount;

    public Product() {
    }

    public Product(int id, String productName, double productAmount) {
        this.id = id;
        this.productName = productName;
        this.productAmount = productAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return id+","+productName+","+productAmount;
    }
    public void ShowInfo(){
        System.out.println(this.toString());
    }
}
