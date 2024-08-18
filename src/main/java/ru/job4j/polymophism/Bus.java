package ru.job4j.polymophism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Движется по дорогам общего пользования");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public int refuel(int fuel) {
        int diesel = 60;
        return fuel * diesel;
    }
}