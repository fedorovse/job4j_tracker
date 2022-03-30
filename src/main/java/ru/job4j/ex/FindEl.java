package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("There is no element \"" + key + "\" in the given array");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            int index = FindEl.indexOf(new String[] {"pp", null, "job4j"}, "lol");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
