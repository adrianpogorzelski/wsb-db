package org.example;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("1. Dodaj książkę");
        System.out.println("2. Usuń książkę");
        System.out.println("3. Pokaż książki");
        System.out.println("4. Edytuj książkę");
        System.out.println("5. Wyjdź z programu");
        input();
    }
    static Scanner scanner = new Scanner(System.in);

    private static int input() {
        Byte input = scanner.nextByte();
        switch (input) {
            case 1: addBook();break;
            case 2: removeBook();break;
            case 3: showBooks();break;
            case 4: editBook();break;
            case 5: break;
            default: input();
        }
        return input;
    }

    private static void editBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Podaj tytuł");
        String title = scanner.nextLine();
        System.out.println("Podaj autora");
        String author = scanner.nextLine();
        Book.edit(id, title, author);
        menu();
    }

    private static void showBooks() {
        List<Book> books = Book.getBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
        menu();
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Podaj tytuł");
        book.title = scanner.nextLine();
        System.out.println("Podaj autora");
        book.author = scanner.nextLine();
        book.save();
        menu();
    }
    private static void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id");
        Byte id = scanner.nextByte();
        Book.delete(Long.valueOf(id));
        menu();
    }

    public static void main(String[] args) {

        menu();

    }


}