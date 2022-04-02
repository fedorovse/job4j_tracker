package ru.job4j.factory;

import java.util.Scanner;

public class TriangleOperator extends ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Ввидите длинну основания треугольника: ");
        int a = input.nextInt();
        System.out.print("Ввидите высоту треугольника: ");
        int h = input.nextInt();
        return new Triangle(a, h);
    }
}
