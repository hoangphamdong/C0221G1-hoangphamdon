package model.repository;

import model.bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    BaseRepository baseRepository =new BaseRepository();

    private static final String INSERT_PRODUCT = "call insert_PRODUCT(?,?,?,?,?,?);";
    private static final String SELECT_ALL_PRODUCT = "select * from product; ";
    final String DELETE_PRODUCT_BY_ID = "delete from product where product_id = ?;";
    final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id=?";
    final String FIND_BY_NAME =
            "select *from product\n" +
                    "where product_name like ?;";

    final String UPDATE_EMPLOYEE_BY_ID = "update employee\n" +
            "set employee_name=?,employee_birthday=?\n" +
            "where employee_id=?;";


    public List<Product> selectAllProduct() {

        List<Product> products = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();

            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_PRODUCT);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("product_id");

                String productName= rs.getString("product_name");

                Double productPrice = rs.getDouble("product_price");

                int productQuantity = rs.getInt("product_quantity");

                String productColor = rs.getString("product_color");

                String productDescription = rs.getString("product_description");

                int categoryId = rs.getInt("category_id");


                products.add(new Product(productId,productName,productPrice,productQuantity,productColor,
                        productDescription,categoryId));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return products;
    }

    public boolean deleteProduct(int id) throws SQLException {
        Connection connection = baseRepository.getConnection();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }


    public List<Product> findByProductName(String name) {
        Connection connection = baseRepository.getConnection();
        Product product=null;
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                int productId = rs.getInt("product_id");

                String productName= rs.getString("product_name");

                Double productPrice = rs.getDouble("product_price");

                int productQuantity = rs.getInt("product_quantity");

                String productColor = rs.getString("product_color");

                String productDescription = rs.getString("product_description");

                int categoryId = rs.getInt("category_id");

                products.add(new Product(productId,productName,productPrice,productQuantity,productColor,
                        productDescription,categoryId));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
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
    public void insertProduct(Product product) {
        try {
            Connection connection = baseRepository.getConnection();

            CallableStatement callableStatement = connection.prepareCall(INSERT_PRODUCT);

            callableStatement.setString(1, product.getProductName());

            callableStatement.setDouble(2, product.getProductPrice());

            callableStatement.setInt(3, product.getProductQuantity());
            callableStatement.setString(4, product.getProductColor());
            callableStatement.setString(5, product.getProductDescription());
            callableStatement.setInt(6, product.getCategoryId());



            System.out.println(callableStatement);

            callableStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);

        }
    }


}
