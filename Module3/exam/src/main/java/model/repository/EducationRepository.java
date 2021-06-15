package model.repository;

import model.bean.EducationDegree;
import model.bean.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository {
    private BaseRepository baseRepository = new BaseRepository();


    private static final String SELECT_ALL_EDUCATION = "select * from education_degree;";

    public List<EducationDegree> selectAllEducation() {
        List<EducationDegree>educationDegrees=new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();

            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_EDUCATION);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int educationDegreeId = rs.getInt("education_degree_id");

                String educationDegreeName=rs.getString("education_degree_name");

                educationDegrees.add(new EducationDegree(educationDegreeId,educationDegreeName));

            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return educationDegrees;
    }
}
