package com.example.service.impl;

import com.example.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public Double convert(Double a, Double b) {
        return a*b;
    }
}
