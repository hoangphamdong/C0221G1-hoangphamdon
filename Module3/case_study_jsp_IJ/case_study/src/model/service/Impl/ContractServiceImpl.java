package model.service.Impl;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements IContractService {
    ContractRepository contractRepository=new ContractRepository();
    @Override
    public List<Contract> selectAllContract() {
        return contractRepository.selectAllContract();
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        contractRepository.insertContract(contract);
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return contractRepository.deleteContract(id);
    }

    @Override
    public List<Contract> findContractByCustomerName(String contractName) {
        return null;
    }
}
