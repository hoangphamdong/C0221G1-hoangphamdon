package model.repository;

import model.bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Hoàng Phạm Đông1", "30/01/2002", "Male", 2466804, "0359756804", "hpdongbmt@gmail.com", "diamond", "Dak lak"));
        customers.put(2, new Customer(2, "Hoàng Phạm Đông2", "30/01/2002", "Male", 2466804, "0359756804", "hpdongbmt@gmail.com", "diamond", "Dak lak"));
        customers.put(3, new Customer(3, "Hoàng Phạm Đông3", "30/01/2002", "Male", 2466804, "0359756804", "hpdongbmt@gmail.com", "diamond", "Dak lak"));
        customers.put(4, new Customer(4, "Hoàng Phạm Đông4", "30/01/2002", "Male", 2466804, "0359756804", "hpdongbmt@gmail.com", "diamond", "Dak lak"));
        customers.put(5, new Customer(5, "Hoàng Phạm Đông5", "30/01/2002", "Male", 2466804, "0359756804", "hpdongbmt@gmail.com", "diamond", "Dak lak"));
        customers.put(6, new Customer(6, "Hoàng Phạm Đông6", "30/01/2002", "Male", 2466804, "0359756804", "hpdongbmt@gmail.com", "diamond", "Dak lak"));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public void save(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public Customer findById(int id) {
        return customers.get(id);
    }

    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    public void remote(int id) {
        customers.remove(id);
    }


}
