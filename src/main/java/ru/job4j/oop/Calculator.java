package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int divide(int a) {
        return a / x;
    }

    public int sumAllOperations(int a) {
        return divide(a) + multiply(a) + sum(a);
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println("resultSum: " + resultSum);
        Calculator calculator1 = new Calculator();
        int resultMultiply = calculator1.multiply(10);
        System.out.println("resultMultiply: " + resultMultiply);
        int resultDivide = Calculator.divide(10);
        System.out.println("resultDivide: " + resultDivide);
        Calculator calculator2 = new Calculator();
        int resultSumAll = calculator2.sumAllOperations(10);
        System.out.println("resultSumAll: " + resultSumAll);
    }
}
