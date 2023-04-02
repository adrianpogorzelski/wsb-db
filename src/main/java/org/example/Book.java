package org.example;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Book {

    Long id;
    String title;
    String author;

    public Book(){};

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void save() {
        String sql = "insert into book " +
                "values ('" + title + "', '" + author + "')";
        new DatabaseConnector().execute(sql);
    }

    public static void delete(Long id) {
        String sql = "delete from book " +
                "where id = '" + id + "'";
        new DatabaseConnector().execute(sql);
    }

    static public List<Book> getBooks() {
        String sql = "select * from book";
        ResultSet rs = new DatabaseConnector().selectData(sql);
        List<Book> books = new ArrayList<>();

        try {
            while (rs.next()) {
                Book book = new Book();
                book.id = rs.getLong("id");
                book.title = rs.getString("title");
                book.author = rs.getString("author");
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return books;
    }

    public String toString() {
        return id + ", " + title + ", " + author;
    }

    public static void edit(Long id, String title, String author) {
        String sql = "update book " +
                "set title='" + title + "', author='" + author + "'" +
                "where id=" + id;
        new DatabaseConnector().execute(sql);
    }
}
