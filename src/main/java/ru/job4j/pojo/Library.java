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
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        swap(books, 0, 3);
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getNumberOfPages());
            }
        }
    }
}
