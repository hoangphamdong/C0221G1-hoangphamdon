package managerProduct.service;

import managerProduct.commons.FileUtils;
import managerProduct.commons.StringUtils;
import managerProduct.exception.IdNotFoundException;
import managerProduct.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    Scanner input = new Scanner(System.in);

    @Override
    public void addProduct() {
        List<Product> productList = FuncWriteAndReadFile.readFile("product.csv");
        int id = -1;
        if (productList.isEmpty()) {
            id = 1;
        } else {
            id = productList.get(productList.size() - 1).getId() + 1;
        }

        System.out.println("Enter Name:");
        String name = input.nextLine();
        System.out.println("Enter amount:");
        String amount = input.nextLine();
        productList.add(new Product(id, name, amount));
        FuncWriteAndReadFile.writeFile("product.csv", productList, false);

    }

    @Override
    public void delete(int id) throws IdNotFoundException {
        boolean inNotFound = true;
        List<Product> productList = FuncWriteAndReadFile.readFile("product.csv");
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(productList.get(i));
                inNotFound = false;
                break;
            }
        }
        if (inNotFound) {
            throw new IdNotFoundException("Id not found");

        }
        FuncWriteAndReadFile.writeFile("product.csv", productList, false);
    }

    @Override
    public List<Product> gatAll() {
        return FuncWriteAndReadFile.readFile("product.csv");
    }
}
