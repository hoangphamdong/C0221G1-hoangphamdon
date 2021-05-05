package managerProduct.service;

import managerProduct.exception.IdNotFoundException;
import managerProduct.models.Product;

import java.util.List;

public interface ProductService {
    void addProduct();

    void delete(int id)throws IdNotFoundException;

    List<Product> gatAll();

}
