package com.example.model.bean;

public class Product {
    private Integer productId;
    private String productName;
    private Double price;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(Integer productId, String productName, Double price, String description, String producer) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
