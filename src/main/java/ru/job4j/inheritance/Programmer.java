package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String lang;

    public Programmer() {
    }

    public Programmer(String lang, boolean canSolder, String name, String surname, String education, String birthday) {
        super(canSolder, name, surname, education, birthday);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void coding() {
        System.out.println("Пишу код!");
    }
}
