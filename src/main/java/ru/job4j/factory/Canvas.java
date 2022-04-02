package ru.job4j.factory;

import java.util.Scanner;

public class Canvas {
    private ShapeOperator operator;

    public Canvas(ShapeOperator operator) {
        this.operator = operator;
    }

    public void demonstrate() {
        this.operator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator;
        System.out.print("Какую фигуру вы хотите построить: ");
        String ans = input.nextLine();
        if ("прямоугольник".equals(ans)) {
            operator = new RectangleOperator();
        } else {
            operator = new TriangleOperator();
        }
        Canvas canvas = new Canvas(operator);
        canvas.demonstrate();
    }
}
