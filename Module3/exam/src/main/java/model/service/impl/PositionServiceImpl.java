package model.service.impl;

import model.bean.Position;
import model.repository.PositionRepository;
import model.service.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    PositionRepository positionRepository =new PositionRepository();
    @Override
    public List<Position> selectAllPosition() {
        return positionRepository.selectAllPosition();
    }
}
