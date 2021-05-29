package model.bean;

/**
 *  id, tên sản phẩm, giá sản phẩm,
 *  mô tả của sản phẩm, nhà sản xuất.
 */
public class Product {
    private int id;
    private String name;
    private double amount;
    private String productDescription;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, double amount, String productDescription, String producer) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.productDescription = productDescription;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
