package ru.job4j.oop;

public class College {

    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student2 student2 = freshman;
        Object o = freshman;
        System.out.println(freshman);
        System.out.println(student2);
        System.out.println(o);
    }
}
