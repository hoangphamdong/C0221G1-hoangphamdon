package model.repository;


import model.bean.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();


    private static final String SELECT_ALL_SERVICE = "select * from service;";

    private static final String INSERT_SERVICES = "call insert_service(?,?,?,?,?,?,?,?,?,?);";

    public List<Service> selectAllCustomer() {
        List<Service> customers = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_SERVICE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int serviceId = rs.getInt("service_id");

                String serviceName = rs.getString("service_name");

                int serviceArea = rs.getInt("service_area");

                Double serviceCost = rs.getDouble("service_cost");

                int serviceMaxPeople = rs.getInt("service_max_people");

                int rentTypeId = rs.getInt("rent_type_id");

                int serviceTypeId = rs.getInt("service_type_id");

                String standardRoom = rs.getString("standard_room");

                String descriptionOtherConvenience = rs.getString("description_other_convenience");

                Double poolArea = rs.getDouble("pool_area");

                int numberOfFloors = rs.getInt("number_of_floors");

                customers.add(new Service(serviceId, serviceName, serviceArea, serviceCost,
                        serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return customers;
    }


    public void insertCustomer(Service service) {
        try {
            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(INSERT_SERVICES);

            callableStatement.setString(1, service.getServiceName());

            callableStatement.setInt(2, service.getServiceArea());

            callableStatement.setDouble(3, service.getServiceCost());

            callableStatement.setInt(4, service.getServiceMaxPeople());

            callableStatement.setInt(5, service.getRentTypeId());

            callableStatement.setInt(6, service.getServiceTypeId());

            callableStatement.setString(7, service.getStandardRom());

            callableStatement.setString(8, service.getDescriptionOtherConvenience());

            callableStatement.setDouble(9, service.getPoolArea());

            callableStatement.setInt(10, service.getNumberOfFloors());

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

