package model.service.impl;

import model.bean.Division;
import model.repository.DivisionRepository;
import model.service.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    DivisionRepository divisionRepository=new DivisionRepository();
    @Override
    public List<Division> selectAllDivision() {
        return divisionRepository.selectAllDivision();
    }
}
