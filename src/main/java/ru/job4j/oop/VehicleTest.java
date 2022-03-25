package ru.job4j.oop;

public class VehicleTest {

    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = {airplane, train, bus};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
