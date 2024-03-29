package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository=new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
customerRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
customerRepository.remove(id);
    }
}
