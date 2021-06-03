package model.repository;

import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    final String UPDATE_CUSTOMER_BY_ID = "update customer\n" +
            "set customer_type_id=?,customer_name=?,\n" +
            "\tcustomer_birthday=?,customer_gender=?,\n" +
            "    customer_id_card=?,customer_phone=?,\n" +
            "    customer_email=?,customer_address=?\n" +
            "where customer_id=?;";
    private static final String SELECT_ALL_CUSTOMERS = "call get_list_customer;";
    private static final String INSERT_CUSTOMERS = "call insert_customer(?,?,?,?,?,?,?,?);";
    final String SELECT_USERS_BY_ID = "select* from customer\n" +
            "where customer_id=?;";
    final String DELETE_Customer_BY_ID = "delete from customer where customer_id = ?;";
    final String FIND_BY_NAME =
            "select *from customer\n" +
                    "where customer_name like ?";



    public void insertCustomer(Customer customer) {
        try {
            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(INSERT_CUSTOMERS);

            callableStatement.setInt(1, customer.getCustomerTypeId());

            callableStatement.setString(2, customer.getCustomerName());

            callableStatement.setString(3, customer.getCustomerBirthday());

            callableStatement.setInt(4, customer.getCustomerGender());

            callableStatement.setString(5, customer.getCustomerIdCard());

            callableStatement.setString(6, customer.getCustomerPhone());

            callableStatement.setString(7, customer.getCustomerEmail());

            callableStatement.setString(8, customer.getCustomerAddress());

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


    public Customer selectUser(int inputID) {
        Connection connection = baseRepository.getConnection();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int customerId = rs.getInt("customer_id");

                int customerTypeId = rs.getInt("customer_type_id");

                String customerName = rs.getString("customer_name");

                String customer_birthday = rs.getString("customer_birthday");

                int customer_gender = rs.getInt("customer_gender");

                String customerIdCard = rs.getString("customer_id_card");

                String customerPhone = rs.getString("customer_phone");

                String customerEmail = rs.getString("customer_email");

                String customerAddress = rs.getString("customer_address");

                customer = new Customer(customerId, customerTypeId, customerName, customer_birthday,
                        customer_gender, customerIdCard, customerPhone, customerEmail, customerAddress);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_CUSTOMERS);
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");

                String typeId = rs.getString("customer_type_name");

                String name = rs.getString("customer_name");

                String birthday = rs.getString("customer_birthday");

                int gender = rs.getInt("customer_gender");

                String idCard = rs.getString("customer_id_card");

                String phone = rs.getString("customer_phone");

                String email = rs.getString("customer_email");

                String address = rs.getString("customer_address");
                customers.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return customers;
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
//        String query = "{call get_customer_by_id(?);}";
        try {

            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(" select * from customer where customer_id=?;");

            callableStatement.setInt(1, id);


            ResultSet rs = callableStatement.executeQuery();


            while (rs.next()) {

                int customerId = rs.getInt("customer_id");

                int customerTypeId = rs.getInt("customer_type_id");

                String customerName = rs.getString("customer_name");

                String customerBirthday = rs.getString("customer_birthday");

                int customerGender = rs.getInt("customer_gender");

                String customerIdCard = rs.getString("customer_id_card");

                String customerPhone = rs.getString("customer_phone");

                String customerEmail = rs.getString("customer_email");

                String customerAddress = rs.getString("customer_address");

                customer = new Customer(customerId, customerTypeId, customerName, customerBirthday,
                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);

            }

        } catch (SQLException e) {

            printSQLException(e);

        }

        return customer;
    }


    public boolean deleteCustomer(int id) throws SQLException {
        Connection connection = baseRepository.getConnection();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Customer_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, customer.getCustomerTypeId());

            preparedStatement.setString(2, customer.getCustomerName());

            preparedStatement.setString(3, customer.getCustomerBirthday());

            preparedStatement.setInt(4, customer.getCustomerGender());

            preparedStatement.setString(5, customer.getCustomerIdCard());

            preparedStatement.setString(6, customer.getCustomerPhone());

            preparedStatement.setString(7, customer.getCustomerEmail());

            preparedStatement.setString(8, customer.getCustomerAddress());

            preparedStatement.setInt(9, customer.getCustomerId());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public List<Customer> findByCustomerName(String customerName) {
        Connection connection = baseRepository.getConnection();
        Customer customer=null;
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%"+customerName+"%");
            ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {

                    int customerId = rs.getInt("customer_id");

                    int customerTypeId = rs.getInt("customer_type_id");

                    String customerName1 = rs.getString("customer_name");

                    String customerBirthday = rs.getString("customer_birthday");

                    int customerGender = rs.getInt("customer_gender");

                    String customerIdCard = rs.getString("customer_id_card");

                    String customerPhone = rs.getString("customer_phone");

                    String customerEmail = rs.getString("customer_email");

                    String customerAddress = rs.getString("customer_address");

                    customer = new Customer(customerId, customerTypeId, customerName1, customerBirthday,
                            customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
                    customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}



