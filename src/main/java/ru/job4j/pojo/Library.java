package ru.job4j.pojo;

public class Library {

    public static void swap(Book[] book, int source, int destination) {
        Book temp = book[source];
        book[source] = book[destination];
        book[destination] = temp;
    }

    public static void main(String[] args) {
        Book history = new Book("History", 293);
        Book geography = new Book("Geography", 354);
        Book cleanCode = new Book("Clean code", 150);
        Book chemistry = new Book("Chemistry", 432);
        Book[] books = new Book[]{history, geography, cleanCode, chemistry};
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        swap(books, 0, 3);
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getNumberOfPages());
            }

        }
    }
}
