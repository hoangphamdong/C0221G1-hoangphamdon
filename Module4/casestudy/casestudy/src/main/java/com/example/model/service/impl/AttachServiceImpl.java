package com.example.model.service.impl;

import com.example.model.entity.AttachService;
import com.example.model.repository.IAttachServiceRepository;
import com.example.model.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AttachServiceImpl implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Integer id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
attachServiceRepository.deleteById(id);
    }

    @Override
    public Page<AttachService> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<AttachService> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
