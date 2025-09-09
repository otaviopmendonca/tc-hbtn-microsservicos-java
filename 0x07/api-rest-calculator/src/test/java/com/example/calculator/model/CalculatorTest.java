package com.example.calculator.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void sumTest() {
        Calculator calc = new Calculator();
        assertEquals(8.0, calc.sum(5.0, 3.0));

    }

    @Test
    public void numbersNullSumTest() {
        Calculator calc = new Calculator();
        assertThrows(NullPointerException.class, () -> calc.sum(null, 5.0));
        assertThrows(NullPointerException.class, () -> calc.sum(5.0, null));
    }

    @Test
    void subTest() {
        Calculator calc = new Calculator();
        assertEquals(0.0, calc.sub(10.0, 10.0));
    }

    @Test
    void divideTest() {
        Calculator calc = new Calculator();
        assertEquals(5.0, calc.divide(25.0, 5.0));
    }

    @Test
    public void divisionByZeroTest() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(0.0, 4.0));
        assertThrows(ArithmeticException.class, () -> calc.divide(4.0, 0.0));
    }

    @Test
    void factorialTest() {
        Calculator calc = new Calculator();
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
        Calculator calc = new Calculator();
        assertEquals(101, calc.integerToBinary(5));
    }

    @Test
    void integerToHexadecimalTest() {
        Calculator calc = new Calculator();
        assertEquals("14", calc.integerToHexadecimal(20));
    }

    @Test
    void calculeDayBetweenDateTest() {
        Calculator calc = new Calculator();
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calc.calculeDayBetweenDate(date1, date2));
    }
}