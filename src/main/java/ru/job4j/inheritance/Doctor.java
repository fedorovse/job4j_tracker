package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean medDiplom;

    public Doctor() {
    }

    public Doctor(boolean medDiplom, String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.medDiplom = medDiplom;
    }

    public boolean getMedDiplom() {
        return medDiplom;
    }

    public void diagnosis() {
        System.out.println("Осматриваю пациента");
    }
}
