package model.service.Impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductRepository productRepository=new ProductRepository();
    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> findByProductName(String name) {
        return productRepository.findByProductName(name);
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        productRepository.insertProduct(product);
    }


    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }
}
