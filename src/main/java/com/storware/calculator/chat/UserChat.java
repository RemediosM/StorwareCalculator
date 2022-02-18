package com.storware.calculator.chat;

import com.storware.calculator.calculation.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserChat {

    @Autowired
    Calculation calculation;

    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Podaj ścieżkę do pliku:");
        String file = scanner.next();
        calculation.printSolution(file);
    }
}
