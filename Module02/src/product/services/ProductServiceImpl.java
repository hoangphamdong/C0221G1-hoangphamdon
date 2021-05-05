package product.services;

import product.commons.IoFile;
import product.exception.IdNotFoundException;
import product.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements productService {
    private static Scanner input=new Scanner(System.in);
    @Override
    public void addNewProduct() {
        List<Product>productList= IoFile.readFile("product.csv");
        int id=-1;
        if(productList.isEmpty()){
            id=1;
        }else {
            id=productList.get(productList.size()-1).getId()+1;
        }
        input.nextLine();
        System.out.println("Enter Name:");
        String name=input.nextLine();
        System.out.println("Enter amount:");
        double amount=input.nextDouble();
        productList.add(new Product(id,name,amount));
        IoFile.writerFile("product.csv",productList,false);
    }

    @Override
    public void delete(int id) throws IdNotFoundException {
        boolean idNotFound=true;
            List<Product>productList=IoFile.readFile("product.csv");
            for(int i=0;i<productList.size();i++){
                if(id==productList.get(i).getId()){
                    productList.remove(productList.get(i));
                    idNotFound=false;
                    break;
                }
            }if(idNotFound){
                throw new IdNotFoundException("id not found");
        }IoFile.writerFile("product.csv",productList,false);

    }

    @Override
    public void getAll() {
        List<Product>productList = IoFile.readFile("product.csv");
        for (Product product:productList){
            System.out.println(product);
        }
    }
}
