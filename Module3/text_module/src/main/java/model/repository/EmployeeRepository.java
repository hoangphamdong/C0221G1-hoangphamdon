package model.repository;

import model.bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
//    BaseRepository baseRepository =new BaseRepository();
//
//    private static final String INSERT_EMPLOYEE = "call insert_employee(?,?);";
//    private static final String SELECT_ALL_EMPLOYEE = "select * from employee; ";
//    final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id = ?;";
//    final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id=?";
//    final String FIND_BY_NAME =
//            "select *from employee\n" +
//                    "where employee_name like ?;";
//
//    final String UPDATE_EMPLOYEE_BY_ID = "update employee\n" +
//            "set employee_name=?,employee_birthday=?\n" +
//            "where employee_id=?;";
//
//
//    public List<Product> selectAllEmployee() {
//
//        List<Product> employees = new ArrayList<>();
//        try {
//            Connection connection = this.baseRepository.getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_EMPLOYEE);
//
//            System.out.println(preparedStatement);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int employeeId = rs.getInt("employee_id");
//
//                String employeeName = rs.getString("employee_name");
//
//                String employeeBirthday = rs.getString("employee_birthday");
//
//
//                employees.add(new Product(employeeId,employeeName,employeeBirthday));
//            }
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//        return employees;
//    }
//
//    public boolean deleteEmployee(int id) throws SQLException {
//        Connection connection = baseRepository.getConnection();
//        boolean rowDelete = false;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
//            preparedStatement.setInt(1, id);
//            rowDelete = preparedStatement.executeUpdate() > 0;
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowDelete;
//    }
//
//
//    public List<Product> findByEmployeeName(String name) {
//        Connection connection = baseRepository.getConnection();
//        Product employee=null;
//        List<Product> customerList = new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
//            preparedStatement.setString(1, "%"+name+"%");
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//
//                int employeeId = rs.getInt("employee_id");
//
//                String employeeName = rs.getString("employee_name");
//
//                String employeeBirthday = rs.getString("employee_birthday");
//
//                employee= new Product(employeeId,employeeName,employeeBirthday);
//                customerList.add(employee);
//            }
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customerList;
//    }
//
//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//    public void insertEmployee(Product employee) {
//        try {
//            Connection connection = baseRepository.getConnection();
//
//            CallableStatement callableStatement = connection.prepareCall(INSERT_EMPLOYEE);
//
//            callableStatement.setString(1, employee.getEmployeeName());
//
//            callableStatement.setString(2, employee.getEmployeeBirthday());
//
//
//
//            System.out.println(callableStatement);
//
//            callableStatement.executeUpdate();
//        } catch (SQLException e) {
//
//            printSQLException(e);
//
//        }
//    }
//
//
//    public Product getEmployeeById(int id) {
//        Product employee = null;
//        try {
//
//            Connection connection = baseRepository.getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareCall(SELECT_EMPLOYEE_BY_ID);
//
//            preparedStatement.setInt(1, id);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//
//                int employeeId = rs.getInt("employee_id");
//
//                String employeeName= rs.getString("employee_name");
//
//                String employeeBirthday = rs.getString("employee_birthday");
//
//               employee = new Product(employeeId,employeeName,employeeBirthday );
//
//            }
//
//        } catch (SQLException e) {
//
//            printSQLException(e);
//
//        }
//
//        return employee;
//    }
//    public boolean updateEmployee(Product employee) throws SQLException {
//        Connection connection = baseRepository.getConnection();
//        boolean check = false;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
//
//
//            preparedStatement.setString(1, employee.getEmployeeName());
//
//            preparedStatement.setString(2, employee.getEmployeeBirthday());
//
//            preparedStatement.setInt(3, employee.getEmployeeId());
//
//
//            check = preparedStatement.executeUpdate() > 0;
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return check;
//    }


}
