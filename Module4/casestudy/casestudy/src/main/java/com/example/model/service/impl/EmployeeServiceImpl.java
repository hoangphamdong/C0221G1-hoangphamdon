package com.example.model.service.impl;

import com.example.model.entity.Employee;
import com.example.model.repository.IEmployeeRepository;
import com.example.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> pageAndSearch(Pageable pageable, String keyword) {
        return employeeRepository.getEmployeeBySearchingName(pageable, "%" + keyword + "%");
    }

    @Override
    public Page<Employee> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
