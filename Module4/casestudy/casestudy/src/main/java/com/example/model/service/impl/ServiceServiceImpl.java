package com.example.model.service.impl;

import com.example.model.entity.Service;
import com.example.model.repository.IServiceRepository;
import com.example.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Service> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<Service> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
