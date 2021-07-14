package com.example.model.service.impl;

import com.example.model.entity.Position;
import com.example.model.repository.IPositionRepository;
import com.example.model.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    IPositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return positionRepository.findById(id).empty();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Page<Position> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<Position> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
