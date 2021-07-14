package com.example.model.service.impl;

import com.example.model.entity.ServiceType;
import com.example.model.repository.IServiceTypeRepository;
import com.example.model.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(Integer id) {
        serviceTypeRepository.deleteById(id);
    }

    @Override
    public Page<ServiceType> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<ServiceType> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
