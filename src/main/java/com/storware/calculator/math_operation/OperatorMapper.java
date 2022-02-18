package com.storware.calculator.math_operation;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.storware.calculator.math_operation.Operator.*;

@Service
public class OperatorMapper {

    private static final String VALID_LAST_OPERATOR = "apply";

    private Set<String> addSet;
    private Set<String> subtractSet;
    private Set<String> multiplySet;
    private Set<String> divideSet;

    public OperatorMapper() {
        addSet = new HashSet<>();
        subtractSet = new HashSet<>();
        multiplySet = new HashSet<>();
        divideSet = new HashSet<>();
        populateAddSet();
        populateSubtractSet();
        populateMultiplySet();
        populateDivideSet();
    }

    public Operator mapTextToOperation(String operationText) {
        if (addSet.contains(operationText)) {
            return ADD;
        } else if (subtractSet.contains(operationText)) {
            return SUBTRACT;
        } else if (multiplySet.contains(operationText)) {
            return MULTIPLY;
        } else if (divideSet.contains(operationText)) {
            return DIVIDE;
        } else if (VALID_LAST_OPERATOR.equals(operationText)) {
            return APPLY;
        } else {
            System.out.println("W aplikacji nie ma zdefiniowanego operatora: " + operationText + "! Wszystkie linie z tym operatorem zostały pominięte w obliczeniach.");
            return WRONG_OPERATOR;
        }
    }

    private void populateAddSet() {
        addSet.add("add");
        addSet.add("plus");
    }

    private void populateSubtractSet() {
        subtractSet.add("sub");
        subtractSet.add("subtract");
        subtractSet.add("minus");
    }

    private void populateMultiplySet() {
        multiplySet.add("multiply");
    }

    private void populateDivideSet() {
        divideSet.add("div");
        divideSet.add("divide");
    }
}
