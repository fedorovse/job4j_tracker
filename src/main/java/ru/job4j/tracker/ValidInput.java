package ru.job4j.tracker;

public class ValidInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean valid = true;
        int result = -1;
        do {
            try {
                result = super.askInt(question);
                valid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        } while (valid);
        return result;
    }
}
