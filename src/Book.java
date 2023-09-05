import DB.DB;

import javax.swing.*;
import java.sql.*;

public class Book {

    private int ISBN;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private  String title;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    private String author;
    public static void show()  {
        ResultSet rs = DB.query("select * from books");
        try {
            while(true) {
                assert rs != null;
                if (!rs.next()) break;
                System.out.println(rs.getString("title"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//the search function
    public static void search(String searchTerm)  {
        ResultSet rs = DB.query("SELECT * FROM books WHERE title LIKE '%" + searchTerm + "%' OR author LIKE '%" + searchTerm + "%'");
        try {
            while(rs.next()) {
                System.out.println(rs.getString("title"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //search by ISBN
    public static void searchISBN(String searchTerm)  {
        ResultSet rs = DB.query("SELECT * FROM books WHERE ISBN LIKE '%" + searchTerm + "%'");
        try {
            while(rs.next()) {
//                System.out.println(rs.getString("title"));
                JOptionPane.showMessageDialog(null,"The book is " +rs.getString("title"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //add a  book

public static void add(String title, String author, String ISBN, String status) {
    String query = "INSERT INTO books (title, author, ISBN, Status) VALUES (?, ?, ?, ?)";
    int rowsAffected = DB.executeUpdate(query, title, author, ISBN, status);
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null,"Book added successfully.");
    } else {
        JOptionPane.showMessageDialog(null,"Failed to add the book.");
    }
}
//delete book not implemented yet
public static void delete(int bookId) {
    String query = "DELETE FROM books WHERE id = ?";
    int rowsAffected = DB.executeUpdate(query, bookId);
    if (rowsAffected > 0) {
        System.out.println("Book deleted successfully.");
    } else {
        System.out.println("Failed to delete the book.");
    }
}
//update book
public static void update( String title, String author, String status , String ISBN) {
    String query = "UPDATE books SET title = ?, author = ?, Status = ? WHERE ISBN = ?";
    int rowsAffected = DB.executeUpdate(query, title, author, ISBN, status);
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Book updated successfully.");
    } else {
        JOptionPane.showMessageDialog(null, "Failed to update the book.");
    }
}




}
