package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean canDraw;

    public Engineer() {
    }

    public Engineer(boolean canSolder, String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.canDraw = canSolder;
    }

    public void useComp() {
        System.out.println("Пишу отчет");
    }

    public boolean isCanDraw() {
        return canDraw;
    }
}
