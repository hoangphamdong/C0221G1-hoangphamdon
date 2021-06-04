package model.service;

import model.bean.Customer;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceService {
    public List<Service> selectAllService();

    public void insertService(Service service) throws SQLException;
}
