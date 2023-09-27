package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.*;

public class DELETE {
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    Scanner sc = new Scanner(System.in);
    TOOL tool = new TOOL();
    DatabaseConfig DB_Config = new DatabaseConfig();
    String url = DB_Config.getUrl();
    String database_username = DB_Config.getUsername();
    String database_password = DB_Config.getPassword();

    public void Delete_User() {
        String UserID;
        boolean isExist = false;
        System.out.print("Enter UserID: ");
        do {
            UserID = input.UserIDInput();
            isExist = select.UserID_isExist(UserID);
            if (!isExist) {
                System.out.println("UserID is not exists!!!");
                tool.delay(2000);

            }
        } while (!isExist);
        if (select.isBorrowingBook(UserID)) {
            System.out.println("Cannot delete because this user is borrowing book!!!");
            tool.delay(2000);

        } else {
            //
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = " DELETE FROM Users WHERE UserID = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, UserID);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Delete book successfully!!!");
                }
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tool.delay(2000);
        }
    }

    public void Delete_Book() {
        String ISBN;
        boolean isExist = false;
        System.out.print("Enter ISBN: ");
        do {
            ISBN = input.ISBNInput();
            isExist = select.ISBN_isExist(ISBN);
            if (!isExist) {
                System.out.println("ISBN is not exists!!!");
                tool.delay(2000);

            }
        } while (!isExist);
        if (select.isBorrowed(ISBN)) {
            System.out.println("Cannot delete because this book is being borrowed!!!");
            tool.delay(2000);

        } else {
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = " DELETE FROM Books WHERE ISBN = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, ISBN);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Delete book successfully!!!");
                }
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tool.delay(2000);
        }
    }

    public void Delete_Publisher() {
        String PublisherID;
        boolean isExist = false;
        System.out.print("Enter PublisherID: ");
        do {
            PublisherID = input.PublisherInput();
            isExist = select.PublisherID_isExist(PublisherID);
            if (!isExist) {
                System.out.println("PublisherID is not exists!!!");
                tool.delay(2000);
            }
        } while (!isExist);
        if (select.isPublisingBook(PublisherID)) {
            System.out.println("Cannot delete because this publisher is supplying book!!!");
            tool.delay(2000);
        } else {
            //
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = " DELETE FROM Publishers WHERE PublisherID = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, PublisherID);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Delete book successfully!!!");
                }
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tool.delay(2000);
        }
    }

    public void Return_Book(String ISBN_String) {
        System.out.println("Total fee for this book is: " + select.getFee(ISBN_String));
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = " DELETE FROM Reports WHERE ISBN = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN_String);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Return book successfully!!!");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tool.delay(2000);
        // sc.nextLine();
    }
}
