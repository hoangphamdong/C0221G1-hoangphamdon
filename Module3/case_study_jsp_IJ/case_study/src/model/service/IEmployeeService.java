package model.service;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();
    public void insertEmployee(Employee employee) throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public Employee selectEmployee(int id);
    public List<Employee> findByEmployeeName(String employeeName);
    public boolean updateEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id);
}
