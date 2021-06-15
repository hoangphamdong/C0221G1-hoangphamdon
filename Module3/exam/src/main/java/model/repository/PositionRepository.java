package model.repository;

import model.bean.Employee;
import model.bean.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    private BaseRepository baseRepository = new BaseRepository();


    private static final String SELECT_ALL_POSITION = "select * from position;";

    public List<Position> selectAllPosition() {
        List<Position>positions=new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnection();

            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_POSITION);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int positionId = rs.getInt("position_id");

                String positionName=rs.getString("position_name");

                positions.add(new Position(positionId,positionName));

            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return positions;
    }
}


