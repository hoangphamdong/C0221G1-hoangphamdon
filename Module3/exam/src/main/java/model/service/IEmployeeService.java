package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();
//    public void insertEmployee(Employee employee) throws SQLException;
 Map<String,String> insertEmployee(Employee employee) throws SQLException;
}
