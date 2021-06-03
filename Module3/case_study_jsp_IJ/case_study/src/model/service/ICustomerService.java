package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;
    void insertUserStore(Customer customer) throws SQLException;

    Customer getCustomerById(int id);
    public List<Customer> findByCustomerName(String customerName);
}
