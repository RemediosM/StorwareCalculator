package com.storware.calculator.calculation;

import com.storware.calculator.file.FileReader;
import com.storware.calculator.math_operation.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Calculation {

    @Autowired
    SimpleArithmetic simpleArithmetic;
    @Autowired
    FileReader fileReader;

    public void printSolution(String file) {
        List<MathExpression> mathExpressions = fileReader.getMathExpressionFromFile(file);
        if (mathExpressions.isEmpty()) {
            System.out.println("Lista jest pusta.");
            return;
        }

        double currentValue;
        MathExpression lastExpression = mathExpressions.get(mathExpressions.size() - 1);
        if (Operator.APPLY.equals(lastExpression.getOperator())) {
            currentValue = lastExpression.getNumber();
        } else {
            System.out.println("Błędny operator zakończenia.");
            return;
        }

        for (MathExpression expression: mathExpressions) {
            currentValue = solve(currentValue, expression.getNumber(), expression.getOperator());
        }
        System.out.println(currentValue);
    }

    private double solve(double currentValue, double b, Operator operator) throws ArithmeticException {
        switch (operator) {
            case ADD:
                return simpleArithmetic.add(currentValue, b);
            case SUBTRACT:
                return simpleArithmetic.sub(currentValue, b);
            case DIVIDE:
                return simpleArithmetic.div(currentValue, b);
            case MULTIPLY:
                return simpleArithmetic.multiply(currentValue, b);
            default:
                return currentValue;
        }
    }

}
