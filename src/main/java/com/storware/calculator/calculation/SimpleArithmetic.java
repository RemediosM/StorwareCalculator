package com.storware.calculator.calculation;

import org.springframework.stereotype.Service;

@Service
public class SimpleArithmetic {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double div(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Dzielenie przez 0 jest niedozwolone!");
        }
    }

    public double multiply(double a, double b) {
        return a * b;
    }


}
