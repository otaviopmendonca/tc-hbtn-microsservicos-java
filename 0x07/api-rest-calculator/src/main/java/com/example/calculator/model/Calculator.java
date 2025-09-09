package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {
    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number2 - number1;
    }

    public Double divide(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        } else if (number1 == 0 || number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if (factorial == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        int start = 1;
        for (int i = 2; i <= factorial; i++) {
            start *= i;
        }
        return start;
    }

    public Integer integerToBinary(Integer integer) {
        if (integer == 0) return 0;

        StringBuilder binary = new StringBuilder();
        int num = integer;

        while (num > 0) {
            binary.append(num % 2);
            num = num / 2;
        }

        return Integer.parseInt(binary.reverse().toString());
    }

    public String integerToHexadecimal(Integer integer) {
        String result = String.format("%X", integer);
        return result;
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }
}