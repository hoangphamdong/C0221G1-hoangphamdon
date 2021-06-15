package model.repository;

import model.bean.Division;
import model.bean.EducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository {
    private BaseRepository baseRepository = new BaseRepository();


    private static final String SELECT_ALL_DIVISION= "select * from division;";

    public List<Division> selectAllDivision() {
        List<Division>divisions=new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();

            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_DIVISION);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int divisionId = rs.getInt("division_id");

                String divisionName=rs.getString("division_name");

                divisions.add(new Division(divisionId,divisionName));

            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return divisions;
    }
}
