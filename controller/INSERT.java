package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.*;

public class INSERT {
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    Scanner sc = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/Library_Management_System";
    String database_username = "root";
    String database_password = "123456";
    TOOL tool = new TOOL();

    public void Create_User() {
        String UserID, Name, Email, Phone, Address, DOB, username, pass;
        boolean isExist = false;
        System.out.println("\t\t\t INFORMATION ");
        System.out.print("Enter UserID: ");
        do {
            UserID = input.UserIDInput();
            isExist = select.UserID_isExist(UserID);
            if (isExist) {
                System.out.println("UserID is exists!!!");
            }

        } while (isExist);
        System.out.print("Enter Name: ");
        Name = input.nameInput();
        System.out.print("Enter Email: ");
        Email = input.EmailInput();
        System.out.print("Enter Phone : ");
        Phone = input.PhoneInput();
        System.out.print("Enter Address: ");
        Address = input.addressInput();
        System.out.print("Enter DOB: ");
        DOB = input.DOBInput();
        System.out.print("Enter Username: ");
        do {
            username = sc.nextLine();
            isExist = select.Username_isExist(username, "User") | select.Username_isExist(username, "Admin");
            if (isExist) {
                System.out.println("Username is exists!!!");
            }
        } while (isExist);
        System.out.print("Enter Password: ");
        pass = sc.nextLine();
        //
        // INSERT INTO Users VALUES
        // ('SE181670','Luffy','luffy@gmail.com','0914749064','Quy
        // Nhon','2004-07-01','Luffy','123');
        //
        // System.out.println(UserID + Name + Email + Phone + Address + DOB + username +
        // pass);
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Users VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserID);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Email);
            preparedStatement.setString(4, Phone);
            preparedStatement.setString(5, Address);
            preparedStatement.setString(6, DOB);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, pass);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Create successfully!!!");
                tool.delay(2000);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // sc.nextLine();
    }

    public void Create_Book() {
        String ISBN, Title, Edition, Author, Category, PublisherID;
        int Price;
        boolean isExist = false;
        System.out.println("\t\t\t INFORMATION ");
        System.out.print("Enter ISBN: ");
        do {
            ISBN = input.ISBNInput();
            isExist = select.ISBN_isExist(ISBN);
            if (isExist) {
                System.out.println("ISBN is exists!!!");
            }
        } while (isExist);
        System.out.print("Enter Title: ");
        Title = input.TitleInput();
        System.out.print("Enter Edition: ");
        Edition = input.EditionInput();
        System.out.print("Enter Author : ");
        Author = input.AuthorInput();
        System.out.print("Enter Category: ");
        Category = input.CategoryInput();
        System.out.print("Enter Price: ");
        Price = input.PriceInput();
        boolean kt = false;
        do {
            System.out.print("Enter PublisherID: ");
            PublisherID = input.PublisherInput();
            kt = select.PublisherID_isExist(PublisherID);
            if (!kt) {
                System.out.println("Publisher is not exists!!!");
            }
        } while (!kt);
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Books VALUES (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN);
            preparedStatement.setString(2, Title);
            preparedStatement.setString(3, Edition);
            preparedStatement.setString(4, Author);
            preparedStatement.setString(5, Category);
            preparedStatement.setInt(6, Price);
            preparedStatement.setString(7, PublisherID);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Create successfully!!!");
                tool.delay(2000);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // sc.nextLine();
    }

    public void Create_Publisher() {
        String PublisherID, Name, Email, Phone, Address;
        boolean isExist = false;
        System.out.println("\t\t\t INFORMATION ");
        System.out.print("Enter PublisherID: ");
        do {
            PublisherID = input.PublisherInput();
            isExist = select.PublisherID_isExist(PublisherID);
            if (isExist) {
                System.out.println("PublisherID is exists!!!");
            }
        } while (isExist);
        System.out.print("Enter Name: ");
        Name = input.nameInput();
        System.out.print("Enter Email: ");
        Email = input.EmailInput();
        System.out.print("Enter Phone : ");
        Phone = input.PhoneInput();
        System.out.print("Enter Address: ");
        Address = input.addressInput();
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Publishers VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PublisherID);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Email);
            preparedStatement.setString(4, Phone);
            preparedStatement.setString(5, Address);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Create successfully!!!");
                tool.delay(2000);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Borrow_Book(String UserID_String, String ISBN_String) {
        System.out.println("Done!!!");
    }

    public void Return_Book(String ISBN_String) {
        System.out.println("aaaaDone!!!");
    }
}
