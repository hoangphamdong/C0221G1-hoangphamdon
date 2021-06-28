package com.example.model.service.impl;

import com.example.model.entity.TypeProduct;
import com.example.model.repository.ITypeRepository;
import com.example.model.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeProductImpl implements ITypeProductService {
    @Autowired
    ITypeRepository typeRepository;
    @Override
    public Iterable<TypeProduct> findByAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<TypeProduct> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(TypeProduct typeProduct) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<TypeProduct> getProductBySearchingName(Pageable pageable, String keyword) {
        return null;
    }
}
