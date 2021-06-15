package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    //    @Override
//    public void insertEmployee(Employee employee) throws SQLException {
//    employeeRepository.insertEmployee(employee);
//    }
    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException {
        Map<String,String> mapMsg=new HashMap<>();
        boolean flag=true;

        if("".equals(employee.getEmployeeName())){
            mapMsg.put("name","please input name");
            flag=false;
        }

        if("".equals(employee.getEmployeeEmail())){
            mapMsg.put("email","Please input email");
            flag=false;
        }
        else if(!employee.getEmployeeEmail().matches("^[a-z]\\S+@\\S+\\.\\S+$")){
            mapMsg.put("email","Invalid format email. Hint: abc@gmail.com");
            flag=false;
        }

        if(flag) {
            employeeRepository.insertEmployee(employee);
        }

        return mapMsg;
    }
}