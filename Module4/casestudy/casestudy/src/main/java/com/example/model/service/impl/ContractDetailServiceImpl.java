package com.example.model.service.impl;

import com.example.model.entity.ContractDetail;
import com.example.model.repository.IContractDetailRepository;
import com.example.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Integer id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public Page<ContractDetail> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<ContractDetail> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
