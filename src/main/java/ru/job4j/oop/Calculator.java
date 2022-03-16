package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int m) {
        return m - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double divide(int d) {
        return (double) d / x;
    }

    public double sumAllOperation(int number) {
        return sum(number) + minus(number) + this.multiply(number) + this.divide(number);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(5));
        System.out.println(Calculator.minus(3));
        Calculator cal = new Calculator();
        System.out.println(cal.multiply(4));
        System.out.println(cal.divide(7));
        System.out.println(cal.sumAllOperation(2));
    }
}
