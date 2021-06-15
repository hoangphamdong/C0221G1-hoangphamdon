package model.service.impl;

import model.bean.EducationDegree;
import model.repository.EducationRepository;
import model.service.IEducationDegree;

import java.util.List;

public class EducationDegreeImpl implements IEducationDegree {
    EducationRepository educationRepository =new EducationRepository();
    @Override
    public List<EducationDegree> selectAllEducation() {
        return educationRepository.selectAllEducation();
    }
}
