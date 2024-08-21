package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String drow() {
        String ln = System.lineSeparator();
        return    " ______ " + ln
                + " |    | " + ln
                + " |____| " + ln;
    }
}
