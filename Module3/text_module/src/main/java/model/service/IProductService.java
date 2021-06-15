package model.service;

import model.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> selectAllProduct();
    boolean deleteProduct(int id) throws SQLException;
    public List<Product> findByProductName(String name);
    Product getProductById(int id);
    public void insertProduct(Product product) throws SQLException;
    public boolean updateProduct(Product product) throws SQLException;
}
