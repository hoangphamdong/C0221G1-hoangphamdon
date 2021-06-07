package model.service;

import model.bean.Contract;
import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IContractService {
    List<Contract> selectAllContract();
    public void insertContract(Contract contract) throws SQLException;
    public boolean deleteContract(int id) throws SQLException;
    public List<Contract> findContractByCustomerName(String contractName);
}
