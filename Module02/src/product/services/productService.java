package product.services;

import product.exception.IdNotFoundException;
import product.models.Product;

import java.util.List;

public interface productService {
    void addNewProduct();
    void delete (int id) throws IdNotFoundException;
   void getAll();
}
