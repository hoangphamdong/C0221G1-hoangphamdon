package model.service.Impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    EmployeeRepository employeeRepository=new EmployeeRepository();
    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllCustomer();
    }
}
