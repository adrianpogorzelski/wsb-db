package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static void menu() {
        System.out.println("1. Dodaj książkę");
        System.out.println("2. Usuń książkę");
        System.out.println("3. Pokaż książki");
        System.out.println("4. Wyjdź z programu");
        input();
    }
    static Scanner scanner = new Scanner(System.in);

    private static int input() {
        Byte input = scanner.nextByte();
        switch (input) {
            case 1: addBook();
            case 2: removeBook();
            case 3: showBooks();
            case 4: break;
            default: input();
        }
        return input;
    }

    private static void showBooks() {
        String sql = "select * from book";
        new DatabaseConnector().selectData(sql);
        System.out.println("\n");
        menu();
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Podaj tytuł");
        String title = scanner.nextLine();
        System.out.println("Podaj autora");
        String author = scanner.nextLine();

        String sql = "insert into book " +
                "values (" + id + ", '" + title + "', '" + author + "')";
        new DatabaseConnector().execute(sql);
        menu();
    }

    private static void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id");
        Byte id = scanner.nextByte();

        String sql = "delete from book " +
                "where id = '" + id + "'";
        new DatabaseConnector().execute(sql);
        menu();
    }

    public static void main(String[] args) {

        menu();

    }


}