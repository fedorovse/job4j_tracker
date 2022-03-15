package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + this.active);
        System.out.println("status: " + this.status);
        System.out.println("message: " + this.message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error empty = new Error();
        Error errorOne = new Error(true, 1, "One");
        Error errorTwo = new Error(true, 2, "Two");
        Error errorThree = new Error(true, 3, "Three");

        empty.printInfo();
        errorOne.printInfo();
        errorTwo.printInfo();
        errorThree.printInfo();
    }
}
