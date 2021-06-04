package model.repository;


import model.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

   private BaseRepository baseRepository =new BaseRepository();
   private static final String SELECT_ALL_EMPLOYEE="select*from employee;";




    public List<Employee> selectAllCustomer() {

        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();

            PreparedStatement preparedStatement= connection.prepareCall(SELECT_ALL_EMPLOYEE);

            System.out.println(preparedStatement);

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()) {
                int  employeeId= rs.getInt("employee_id");

                String employeeName = rs.getString("employee_name");

                String employeeBirthday = rs.getString("employee_birthday");

                String employeeIdCard = rs.getString("employee_id_card");

                Double employeeSalary = rs.getDouble("employee_salary");

                String employeePhone = rs.getString("employee_phone");

                String employeeEmail= rs.getString("employee_email");

                String employee_address = rs.getString("employee_address");

                int positionId = rs.getInt("position_id");

                int educationDegreeId = rs.getInt("education_degree_id");

                int divisionId = rs.getInt("division_id");

                String userName= rs.getString("user_name");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday , employeeIdCard
                        ,employeeSalary,employeePhone, employeeEmail, employee_address,positionId,educationDegreeId,divisionId,userName));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return employees;
    }
}
