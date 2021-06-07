package model.repository;

import model.bean.Contract;
import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {

    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CONTRACT = "call list_customer_user_contract;";
    private static final String INSERT_CONTRACT = "call insert_contract(?,?,?,?,?,?,?)";
    final String DELETE_CONTRACT_BY_ID = "delete from contract where contract_id = ?;";
    final String FIND_BY_NAME =
            "select *from contract\n" +
                    "where customer_name like ?";
    public  List<Contract> selectAllContract() {
        List<Contract> contracts = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_CONTRACT);
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {


                String customName = rs.getString("customer_name");

                String serviceName = rs.getString("service_name");

                String contractStartDate = rs.getString("contract_start_date");

                String contractEndDate = rs.getString("contract_end_date");

                String attachServiceName = rs.getString("attach_service_name");

                int quantity = rs.getInt("quantity");

                contracts.add(new Contract(contractStartDate, contractEndDate, customName,
                        serviceName, attachServiceName, quantity));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return contracts;
    }

    public void insertContract(Contract contract) {
        try {
            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(INSERT_CONTRACT);

            callableStatement.setString(1, contract.getContractStartDate());

            callableStatement.setString(2, contract.getContractEndDate());

            callableStatement.setDouble(3, contract.getContractDeposit());

            callableStatement.setDouble(4, contract.getContractTotalMoney());

            callableStatement.setInt(5, contract.getEmployeeId());

            callableStatement.setInt(6, contract.getCustomerId());

            callableStatement.setInt(7, contract.getServiceID());


            System.out.println(callableStatement);

            callableStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);

        }


    }private void printSQLException(SQLException ex) {
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

    public boolean deleteContract(int id) throws SQLException {
        Connection connection = baseRepository.getConnection();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

//    public List<Contract> findContractByCustomerName(String ipContractName) {
//        Connection connection = baseRepository.getConnection();
//        Contract contract=null;
//        List<Contract> contractList = new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
//            preparedStatement.setString(1, "%"+ipContractName+"%");
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//
//                int customerId = rs.getInt("customer_id");
//
//                int customerTypeId = rs.getInt("customer_type_id");
//
//                String customerName1 = rs.getString("customer_name");
//
//                String customerBirthday = rs.getString("customer_birthday");
//
//                int customerGender = rs.getInt("customer_gender");
//
//                String customerIdCard = rs.getString("customer_id_card");
//
//                String customerPhone = rs.getString("customer_phone");
//
//                String customerEmail = rs.getString("customer_email");
//
//                String customerAddress = rs.getString("customer_address");
//
//                customer = new Customer(customerId, customerTypeId, customerName1, customerBirthday,
//                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
//                customerList.add(customer);
//            }
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customerList;
//    }

}
