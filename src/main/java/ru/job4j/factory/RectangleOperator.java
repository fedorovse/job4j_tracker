package ru.job4j.factory;

import java.util.Scanner;

public class RectangleOperator extends ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.print("Ввидите длинну прямоугольника: ");
        int a = input.nextInt();
        System.out.print("Ввидите ширину прямоугольника: ");
        int b = input.nextInt();
        return new Rectangle(a, b);
    }
}
