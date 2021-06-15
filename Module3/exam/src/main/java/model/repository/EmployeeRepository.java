package model.repository;

import model.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
   private BaseRepository baseRepository=new BaseRepository();

    private static final String INSERT_EMPLOYEE = "call insert_employee(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_EMPLOYEE = "select e.employee_id,e.employee_name,e.employee_birthday,\n" +
            "\t\te.employee_phone,e.employee_email,\n" +
            "        e.employee_address\n" +
            "from employee as e;";


    public List<Employee> selectAllEmployee() {

        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();

            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_EMPLOYEE);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");

                String employeeName = rs.getString("employee_name");

                String employeeBirthday = rs.getString("employee_birthday");


                String employeePhone = rs.getString("employee_phone");

                String employeeEmail = rs.getString("employee_email");

                String employee_address = rs.getString("employee_address");

                employees.add(new Employee(employeeId,employeeName,employeeBirthday,employeePhone,employeeEmail,employee_address));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return employees;
    }

    public void insertEmployee(Employee employee) {
        try {
            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(INSERT_EMPLOYEE);

            callableStatement.setString(1, employee.getEmployeeName());

            callableStatement.setString(2, employee.getEmployeeBirthday());

            callableStatement.setString(3, employee.getEmployeeIdCard());

            callableStatement.setDouble(4, employee.getEmployeeSalary());

            callableStatement.setString(5, employee.getEmployeePhone());

            callableStatement.setString(6, employee.getEmployeeEmail());

            callableStatement.setString(7, employee.getEmployeeAddress());

            callableStatement.setInt(8, employee.getPositionId());

            callableStatement.setInt(9, employee.getEducationDegreeId());

            callableStatement.setInt(10, employee.getDivisionId());

            callableStatement.setString(11, employee.getUsername());


            System.out.println(callableStatement);

            callableStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);

        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
