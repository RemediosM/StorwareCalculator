package com.storware.calculator.calculation;

import com.storware.calculator.math_operation.Operator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MathExpression {

    private Operator operator;
    private double number;

}
