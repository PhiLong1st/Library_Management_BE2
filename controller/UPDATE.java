package controller;

import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UPDATE {
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    DatabaseConfig DB_Config = new DatabaseConfig();
    String url = DB_Config.getUrl();
    String database_username = DB_Config.getUsername();
    String database_password = DB_Config.getPassword();
    TOOL tool = new TOOL();
    Scanner sc = new Scanner(System.in);

    public void Update_User(String UserID_String) {
        String UserID, Name, Email, Phone, Address, DOB;
        boolean isExist = false;
        System.out.println("\t\t\tYOUR INFORMATION ");
        System.out.print("Enter UserID: ");
        do {
            UserID = input.UserIDInput();
            if (UserID.equalsIgnoreCase(UserID_String)) {
                isExist = false;
            } else {
                isExist = select.UserID_isExist(UserID);
                if (isExist) {
                    System.out.println("UserID is exists!!!");
                }
            }
        } while (isExist);
        System.out.print("Enter new Name: ");
        Name = input.nameInput();
        System.out.print("Enter new Email: ");
        Email = input.EmailInput();
        System.out.print("Enter new Phone : ");
        Phone = input.PhoneInput();
        System.out.print("Enter new Address: ");
        Address = input.addressInput();
        System.out.print("Enter new DOB: ");
        DOB = input.DOBInput();
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = " UPDATE Users SET UserID = ?, Name = ?, Email = ?, Phone = ?, Address = ?, DOB = ? WHERE UserID = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserID);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Email);
            preparedStatement.setString(4, Phone);
            preparedStatement.setString(5, Address);
            preparedStatement.setString(6, DOB);
            preparedStatement.setString(7, UserID_String);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successfully!!!");
                tool.delay(2000);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update_Book(String ISBN_String) {
        String ISBN, Title, Edition, Author, Category, PublisherID;
        int Price;
        boolean isExist = false;
        System.out.println("\t\t\tBOOK'S INFORMATION ");
        System.out.print("Enter ISBN: ");
        do {
            ISBN = input.ISBNInput();
            if (ISBN.equalsIgnoreCase(ISBN_String)) {
                isExist = false;
            } else {
                isExist = select.ISBN_isExist(ISBN);
                if (isExist) {
                    System.out.println("ISBN is exists!!!");
                }
            }
        } while (isExist);
        System.out.print("Enter new Title: ");
        Title = input.TitleInput();
        System.out.print("Enter new Edition: ");
        Edition = input.EditionInput();
        System.out.print("Enter new Author : ");
        Author = input.AuthorInput();
        System.out.print("Enter new Category: ");
        Category = input.CategoryInput();
        System.out.print("Enter new Price: ");
        Price = input.PriceInput();
        System.out.print("Enter new PublisherID: ");
        do {
            PublisherID = input.PublisherInput();
        } while (!select.PublisherID_isExist(PublisherID));
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = " UPDATE Books SET ISBN = ?, Title = ?, Edition = ?, Author = ?, Category = ?, Price = ?, PublisherID = ? WHERE ISBN = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN);
            preparedStatement.setString(2, Title);
            preparedStatement.setString(3, Edition);
            preparedStatement.setString(4, Author);
            preparedStatement.setString(5, Category);
            preparedStatement.setInt(6, Price);
            preparedStatement.setString(7, PublisherID);
            preparedStatement.setString(8, ISBN_String);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successfully!!!");
                tool.delay(2000);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update_Publisher(String PublisherID_String) {
        String PublisherID, Name, Email, Phone, Address;
        boolean isExist = false;
        System.out.println("\t\t\tPublisher'S INFORMATION ");
        System.out.print("Enter PublisherID: ");
        do {
            PublisherID = input.PublisherInput();
            if (PublisherID.equalsIgnoreCase(PublisherID_String)) {
                isExist = false;
            } else {
                isExist = select.PublisherID_isExist(PublisherID);
                if (isExist) {
                    System.out.println("PublisherID is exists!!!");
                }
            }
        } while (isExist);
        System.out.print("Enter new Name: ");
        Name = input.nameInput();
        System.out.print("Enter new Email: ");
        Email = input.EmailInput();
        System.out.print("Enter new Phone : ");
        Phone = input.PhoneInput();
        System.out.print("Enter new Address: ");
        Address = input.addressInput();
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = " UPDATE Publishers SET PublisherID = ?, Name = ?, Email = ?, Phone = ?, Address = ? WHERE PublisherID = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PublisherID);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Email);
            preparedStatement.setString(4, Phone);
            preparedStatement.setString(5, Address);
            preparedStatement.setString(6, PublisherID_String);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successfully!!!");
                tool.delay(2000);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
