package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Активный: " + active);
        System.out.println("Количество: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error1 = new Error(true, 1, "')' or ',' expected");
        Error error2 = new Error(false, 0, "");
        Error error3 = new Error(true, 1, "variable error2 is "
                + "already defined in method main(java.lang.String[])");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
