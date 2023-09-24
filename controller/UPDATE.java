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
    String url = "jdbc:mysql://localhost:3306/Library_Management_System";
    String database_username = "root";
    String database_password = "123456";
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
        //
        //

        // UPDATE Users
        // SET UserID = 'SE181670', Name = 'Luffy', Email = 'luffy@gmail.com', Phone =
        // '0914749064', Address = 'Quy Nhon', DOB ='2004-07-01'
        // WHERE UserID = 'SE181670' ;

        //
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
        // sc.nextLine();
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
        do {
            System.out.print("Enter PublisherID: ");
            PublisherID = input.PublisherInput();
        } while (!select.PublisherID_isExist(PublisherID));
        /*
         * UPDATE Books
         * SET ISBN= 'ISBN000001', Title = 'Thuyen truong', Edition = '1', Author='To
         * Hoai',Category = 'Truyen ngan', Price = 5000, PublisherID= 'NXB001'
         * WHERE ISBN= 'ISBN000001';
         */
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
        // sc.nextLine();
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
        // sc.nextLine();
    }
}
