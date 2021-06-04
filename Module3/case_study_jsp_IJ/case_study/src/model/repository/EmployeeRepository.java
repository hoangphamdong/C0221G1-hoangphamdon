package model.repository;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_EMPLOYEE = "select*from employee;";

    private static final String INSERT_EMPLOYEE = "call insert_employee(?,?,?,?,?,?,?,?,?,?,?);";

    final String DELETE_EMPLOY_BY_ID = "delete from employee where employee_id = ?;";

    final String SELECT_EMPLOYEE_BY_ID = "select* from employee\n" +
            "where employee_id=?;";

    final String FIND_BY_NAME =
            "select *from employee\n" +
                    "where employee_name like ?";

    final String UPDATE_EMPLOYEE_BY_ID = "update employee\n" +
            "set employee_name=?,employee_birthday=?,\n" +
            "\temployee_id_card=?,employee_salary=?,\n" +
            "    employee_phone=?,employee_email=?,\n" +
            "    employee_address=?,position_id=?\n" +
            "    education_degree_id=?,division_id=?\n" +
            "    user_name=?" +
            "where employee_id=?;";

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

                String employeeIdCard = rs.getString("employee_id_card");

                Double employeeSalary = rs.getDouble("employee_salary");

                String employeePhone = rs.getString("employee_phone");

                String employeeEmail = rs.getString("employee_email");

                String employee_address = rs.getString("employee_address");

                int positionId = rs.getInt("position_id");

                int educationDegreeId = rs.getInt("education_degree_id");

                int divisionId = rs.getInt("division_id");

                String userName = rs.getString("user_name");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard
                        , employeeSalary, employeePhone, employeeEmail, employee_address, positionId, educationDegreeId, divisionId, userName));
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

            callableStatement.setInt(8, employee.getPosition());

            callableStatement.setInt(9, employee.getEducationDegree());

            callableStatement.setInt(10, employee.getDivisionId());

            callableStatement.setString(11, employee.getUserName());

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


    public boolean deleteEmployee(int id) throws SQLException {
        Connection connection = baseRepository.getConnection();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOY_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public Employee selectEmployee(int inputID) {
        Connection connection = baseRepository.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int employeeId = rs.getInt("employee_id");

                String employeeName = rs.getString("employee_name");

                String employeeBirthday = rs.getString("employee_birthday");

                String employeeIdCard = rs.getString("employee_id_card");

                Double employeeSalary = rs.getDouble("employee_salary");

                String employeePhone = rs.getString("employee_phone");

                String employeeEmail = rs.getString("employee_email");

                String employee_address = rs.getString("employee_address");

                int positionId = rs.getInt("position_id");

                int educationDegreeId = rs.getInt("education_degree_id");

                int divisionId = rs.getInt("division_id");

                String userName = rs.getString("user_name");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard
                        , employeeSalary, employeePhone, employeeEmail, employee_address, positionId, educationDegreeId, divisionId, userName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> findByEmployeeName(String ipEmployeeName) {
        Connection connection = baseRepository.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + ipEmployeeName + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {


                int employeeId = rs.getInt("employee_id");

                String employeeName = rs.getString("employee_name");

                String employeeBirthday = rs.getString("employee_birthday");

                String employeeIdCard = rs.getString("employee_id_card");

                Double employeeSalary = rs.getDouble("employee_salary");

                String employeePhone = rs.getString("employee_phone");

                String employeeEmail = rs.getString("employee_email");

                String employee_address = rs.getString("employee_address");

                int positionId = rs.getInt("position_id");

                int educationDegreeId = rs.getInt("education_degree_id");

                int divisionId = rs.getInt("division_id");

                String userName = rs.getString("user_name");
                employeeList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard
                        , employeeSalary, employeePhone, employeeEmail, employee_address, positionId, educationDegreeId, divisionId, userName));

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, employee.getEmployeeName());

            preparedStatement.setString(2, employee.getEmployeeBirthday());

            preparedStatement.setString(3, employee.getEmployeeIdCard());

            preparedStatement.setDouble(4, employee.getEmployeeSalary());

            preparedStatement.setString(5, employee.getEmployeePhone());

            preparedStatement.setString(6, employee.getEmployeeEmail());

            preparedStatement.setString(7, employee.getEmployeeAddress());

            preparedStatement.setInt(8, employee.getPosition());

            preparedStatement.setInt(9, employee.getEducationDegree());

            preparedStatement.setInt(10, employee.getDivisionId());

            preparedStatement.setString(11, employee.getUserName());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
//        String query = "{call get_customer_by_id(?);}";
        try {

            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(" select * from employee where employee_id=?;");

            callableStatement.setInt(1, id);


            ResultSet rs = callableStatement.executeQuery();


            while (rs.next()) {

                int employeeId = rs.getInt("employee_id");

                String employeeName = rs.getString("employee_name");

                String employeeBirthday = rs.getString("employee_birthday");

                String employeeIdCard = rs.getString("employee_id_card");

                Double employeeSalary = rs.getDouble("employee_salary");

                String employeePhone = rs.getString("employee_phone");

                String employeeEmail = rs.getString("employee_email");

                String employee_address = rs.getString("employee_address");

                int positionId = rs.getInt("position_id");

                int educationDegreeId = rs.getInt("education_degree_id");

                int divisionId = rs.getInt("division_id");

                String userName = rs.getString("user_name");
                employee=new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard
                        , employeeSalary, employeePhone, employeeEmail, employee_address, positionId, educationDegreeId, divisionId, userName);

            }

        } catch (SQLException e) {

            printSQLException(e);

        }

        return employee;
    }
}



