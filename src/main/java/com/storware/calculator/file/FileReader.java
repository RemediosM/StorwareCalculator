package com.storware.calculator.file;

import com.storware.calculator.calculation.MathExpression;
import com.storware.calculator.math_operation.Operator;
import com.storware.calculator.math_operation.OperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileReader {

    private static final String SEPARATOR = " ";

    @Autowired
    OperatorMapper operatorMapper;

    public List<MathExpression> getMathExpressionFromFile(String file) {
        List<MathExpression> mathExpressions = new ArrayList<>();
        readFile(file).forEach(s -> {
            String[] sSplit = s.split(SEPARATOR);
            Operator operator = operatorMapper.mapTextToOperation(sSplit[0]);
            mathExpressions.add(new MathExpression(operator, Double.parseDouble(sSplit[1])));
        });
        return mathExpressions;
    }

    private List<String> readFile(String file) {
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Paths.get(file));
            result.removeAll(Arrays.asList("", null));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
