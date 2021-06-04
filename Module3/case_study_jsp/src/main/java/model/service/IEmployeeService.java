package model.service;

import model.bean.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();
}
