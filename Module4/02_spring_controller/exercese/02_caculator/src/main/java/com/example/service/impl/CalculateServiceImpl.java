package com.example.service.impl;

import com.example.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements ICalculateService {
    @Override
    public Double calculator(double number1, double number2, String calculator) {
        double result = 0;
        switch (calculator) {
            case "Addition(+)":
                result = number1 + number2;
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                break;
            case "Multiplication(x)":
                result = number1 * number2;
                break;
            case "Division(/)":
                result = number1 / number2;
                break;

        }
        return result;
    }
}
