package ru.job4j.polymophism;

public interface Transport {
    void move();

    void passengers(int count);

    int refuel(int fuel);
}
