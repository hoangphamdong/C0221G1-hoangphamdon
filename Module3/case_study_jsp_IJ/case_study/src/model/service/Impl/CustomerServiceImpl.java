package model.service.Impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {

        return customerRepository.selectUser(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public void insertUserStore(Customer customer) throws SQLException {

    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> findByCustomerName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }
}
