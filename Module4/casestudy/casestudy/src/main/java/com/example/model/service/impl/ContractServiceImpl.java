package com.example.model.service.impl;

import com.example.model.entity.Contract;
import com.example.model.repository.IContractRepository;
import com.example.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> pageAndSearch(Pageable pageable, String keyword) {
        return contractRepository.getContractBySearching(pageable,keyword);
    }

    @Override
    public Page<Contract> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
