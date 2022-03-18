package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book terem = new Book("Teremok", 25);
        Book cleanCode = new Book("Clean code", 670);
        Book murzilka = new Book("Murzilka", 33);
        Book stihi = new Book("Stihi", 320);
        Book[] books = new Book[4];
        books[0] = terem;
        books[1] = cleanCode;
        books[2] = murzilka;
        books[3] = stihi;
        for (Book b: books) {
            System.out.println(b.getName() + " " + b.getPages());
        }

        System.out.println();
        Book buf = books[0];
        books[0] = books[3];
        books[3] = buf;
        for (Book b: books) {
            System.out.println(b.getName() + " " + b.getPages());
        }

        System.out.println();
        for (Book b: books) {
            if (b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " " + b.getPages());
            }
        }

    }
}
