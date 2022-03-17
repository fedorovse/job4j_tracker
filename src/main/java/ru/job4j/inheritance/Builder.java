package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean canBuild;

    public Builder(boolean canBuild) {
        super();
        this.canBuild = canBuild;
    }

    public Builder() {
    }

    public boolean getCanBuild() {
        return canBuild;
    }

    public void build() {
        System.out.println("Строю!");
    }
}
