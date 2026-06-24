package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println("Setup Executed");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Teardown Executed");
        calculator = null;
    }

    @Test
    void testAdd() {
        int num1 = 10;
        int num2 = 20;
        int result = calculator.add(num1, num2);
        assertEquals(30, result);
    }

    @Test
    void testMultiply() {
        int num1 = 5;
        int num2 = 4;

        int result = calculator.multiply(num1, num2);
        assertEquals(20, result);
    }
}