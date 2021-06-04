package model.service.Impl;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.service.IServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    ServiceRepository serviceRepository=new ServiceRepository();
    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllCustomer();
    }

    @Override
    public void insertService(Service service) throws SQLException {
            serviceRepository.insertCustomer(service);
    }
}
