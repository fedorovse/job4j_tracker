package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

public class ValidateInput implements Input {
    private final Input in;
    private final Output out;

    public ValidateInput(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean valid = true;
        int result = -1;
        do {
            try {
                result = in.askInt(question);
                valid = false;
            } catch (NumberFormatException nfe) {

                out.println("Пожалуйста, введите корректные данные");
            }
        } while (valid);
        return result;
    }
}
