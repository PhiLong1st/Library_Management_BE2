package controller;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class SELECT {
    String url = "jdbc:mysql://localhost:3306/Library_Management_System";
    String database_username = "root";
    String database_password = "123456";
    Scanner sc = new Scanner(System.in);

    public boolean isBorrowingBook(String UserID_String) {
        boolean isBorrow = false;
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Reports WHERE UserID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserID_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isBorrow = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isBorrow;
    }

    public boolean isPublisingBook(String PublisherID_String) {
        boolean isBorrow = false;
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Books WHERE PublisherID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PublisherID_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isBorrow = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isBorrow;
    }

    public boolean isBorrowed(String ISBN_String) {
        boolean isBorrowed = false;
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Reports WHERE ISBN = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isBorrowed = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isBorrowed;
    }

    public boolean Username_isExist(String usernameString, String typeString) {
        boolean exists = true;// typeString (admin/user)
        // SELECT * FROM typeString WHERE username = 'usernameString';
        if (typeString.equalsIgnoreCase("admin")) {
            // SELECT * FROM Staff WHERE username = 'Sanji';
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM Staff WHERE username = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usernameString);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    exists = false;
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (typeString.equalsIgnoreCase("user")) {
            // SELECT * FROM Users WHERE username = 'Luffy';
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM Users WHERE username = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usernameString);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    exists = false;
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exists;
    }

    public boolean UserID_isExist(String UserID_String) {
        boolean exists = true;
        // SELECT * FROM Users WHERE UserID = 'usernameString';
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE UserID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserID_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                exists = false;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public boolean ISBN_isExist(String ISBN_String) {
        boolean exists = true;
        // SELECT * FROM Books WHERE ISBN = 'ISBN_String';
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Books WHERE ISBN = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                exists = false;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return exists;
    }

    public boolean PublisherID_isExist(String PublisherID_String) {
        boolean exists = true;
        // SELECT * FROM Publishers WHERE PublisherID = 'PublisherID_String';
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Publishers WHERE PublisherID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PublisherID_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                exists = false;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return exists;
    }

    public boolean checkAccount(String usernameString, String passString, String typeString) {
        boolean isGood = true;
        // check account exist in table

        if (typeString.equalsIgnoreCase("admin")) {
            // SELECT * FROM Staff WHERE username = 'Sanji' AND pass = '123';
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM Staff WHERE username = ? AND pass = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usernameString);
                preparedStatement.setString(2, passString);
                ResultSet resultSet = preparedStatement.executeQuery();
                // System.out.println("SQL: " + preparedStatement.toString());
                // System.out.println("aaaa");
                if (!resultSet.next()) {
                    // System.out.println("No result");
                    isGood = false;
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (typeString.equalsIgnoreCase("user")) {
            // SELECT * FROM Users WHERE username = 'Luffy' AND pass = '123';
            try {
                Connection connection = DriverManager.getConnection(url, database_username, database_password);
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM Users WHERE username = ? AND pass = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usernameString);
                preparedStatement.setString(2, passString);
                // System.out.println("SQL: " + preparedStatement.toString());
                // // System.out.println("aaaa");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    // System.out.println("No result");
                    isGood = false;
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Input \"Admin\" or \"User\"");
            return false;
        }
        // isGood = false khi khong co account trong database
        if (!isGood) {
            if (!Username_isExist(usernameString, typeString)) {// khong co tai khoan
                System.out.println("Account is not exists!");
            } else {// co tai khoan nhung sai pass
                System.out.println("Password wrong!");
            }
        } else {
            System.out.println("Login successfully!");
        }
        return isGood;
    }

    public void SearchBook_ISBN(String ISBN_String) {
        // System.out.println("SearchBook_ISBN");

        // SELECT ISBN, Title, Edition, Author, Category, Price,
        // CASE
        // WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN
        // 'Available'
        // WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not
        // Available'
        // END AS isBorrow
        // FROM Books WHERE ISBN = 'ISBN 000001' ORDER BY ISBN;
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT ISBN, Title, Edition, Author, Category, Price,\r\n" + //
                    "          CASE\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN\r\n" + //
                    "          'Available'\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not\r\n" + //
                    "          Available'\r\n" + //
                    "          END AS isBorrow\r\n" + //
                    "          FROM Books WHERE ISBN = ? ORDER BY ISBN;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String ISBN = resultSet.getString("ISBN");
                    String Title = resultSet.getString("Title");
                    String Edition = resultSet.getString("Edition");
                    String Author = resultSet.getString("Author");
                    String Category = resultSet.getString("Category");
                    int Price = resultSet.getInt("Price");
                    String isBorrow = resultSet.getString("isBorrow");
                    //
                    System.out.println("ISBN: " + ISBN);
                    System.out.println("Title: " + Title);
                    System.out.println("Edition: " + Edition);
                    System.out.println("Author: " + Author);
                    System.out.println("Category: " + Category);
                    System.out.println("Price: " + Price);
                    System.out.println("isBorrow: " + isBorrow);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void SearchBook_Author(String Author_String) {
        System.out.println("SearchBook_Author");
         try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT ISBN, Title, Edition, Author, Category, Price,\r\n" + //
                    "          CASE\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN\r\n" + //
                    "          'Available'\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not\r\n" + //
                    "          Available'\r\n" + //
                    "          END AS isBorrow\r\n" + //
                    "          FROM Books WHERE Author = ? ORDER BY ISBN;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Author_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String ISBN = resultSet.getString("ISBN");
                    String Title = resultSet.getString("Title");
                    String Edition = resultSet.getString("Edition");
                    String Author = resultSet.getString("Author");
                    String Category = resultSet.getString("Category");
                    int Price = resultSet.getInt("Price");
                    String isBorrow = resultSet.getString("isBorrow");
                    //
                    System.out.println("ISBN: " + ISBN);
                    System.out.println("Title: " + Title);
                    System.out.println("Edition: " + Edition);
                    System.out.println("Author: " + Author);
                    System.out.println("Category: " + Category);
                    System.out.println("Price: " + Price);
                    System.out.println("isBorrow: " + isBorrow);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
         * SELECT ISBN, Title, Edition, Author, Category, Price,
         * CASE
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN
         * 'Available'
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not
         * Available'
         * END AS isBorrow
         * FROM Books WHERE Author = 'To Hoai' ORDER BY ISBN;
         */
    }

    public void SearchBook_Category(String Category_String) {
        System.out.println("SearchBook_Category");
         try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT ISBN, Title, Edition, Author, Category, Price,\r\n" + //
                    "          CASE\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN\r\n" + //
                    "          'Available'\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not\r\n" + //
                    "          Available'\r\n" + //
                    "          END AS isBorrow\r\n" + //
                    "          FROM Books WHERE Category = ? ORDER BY ISBN;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Category_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String ISBN = resultSet.getString("ISBN");
                    String Title = resultSet.getString("Title");
                    String Edition = resultSet.getString("Edition");
                    String Author = resultSet.getString("Author");
                    String Category = resultSet.getString("Category");
                    int Price = resultSet.getInt("Price");
                    String isBorrow = resultSet.getString("isBorrow");
                    //
                    System.out.println("ISBN: " + ISBN);
                    System.out.println("Title: " + Title);
                    System.out.println("Edition: " + Edition);
                    System.out.println("Author: " + Author);
                    System.out.println("Category: " + Category);
                    System.out.println("Price: " + Price);
                    System.out.println("isBorrow: " + isBorrow);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
         * SELECT * FROM Books WHERE Author = 'To Hoai' ORDER BY ISBN; -- author
         * SELECT ISBN, Title, Edition, Author, Category, Price,
         * CASE
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN
         * 'Available'
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not
         * Available'
         * END AS isBorrow
         * FROM Books WHERE Category = 'Truyen ngan' ORDER BY ISBN;
         */
    }

    public void SearchBook_Publisher(String Publisher_String) {
        System.out.println("SearchBook_Publisher");
         try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT ISBN, Title, Edition, Author, Category, Price,\r\n" + //
                    "          CASE\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN\r\n" + //
                    "          'Available'\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not\r\n" + //
                    "          Available'\r\n" + //
                    "          END AS isBorrow\r\n" + //
                    "          FROM Books WHERE PublisherID = ? ORDER BY ISBN;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Publisher_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String ISBN = resultSet.getString("ISBN");
                    String Title = resultSet.getString("Title");
                    String Edition = resultSet.getString("Edition");
                    String Author = resultSet.getString("Author");
                    String Category = resultSet.getString("Category");
                    int Price = resultSet.getInt("Price");
                    String isBorrow = resultSet.getString("isBorrow");
                    //
                    System.out.println("ISBN: " + ISBN);
                    System.out.println("Title: " + Title);
                    System.out.println("Edition: " + Edition);
                    System.out.println("Author: " + Author);
                    System.out.println("Category: " + Category);
                    System.out.println("Price: " + Price);
                    System.out.println("isBorrow: " + isBorrow);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
         * SELECT ISBN, Title, Edition, Author, Category, Price,
         * CASE
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN
         * 'Available'
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not
         * Available'
         * END AS isBorrow
         * FROM Books INNER JOIN Publishers ON Books.PublisherID =
         * Publishers.PublisherID
         * WHERE Publishers.PublisherID = 'NXB001' ORDER BY ISBN;
         */
    }

    public void SearchBook_Title(String Title_String) {
        System.out.println("SearchBook_Title");
         try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT ISBN, Title, Edition, Author, Category, Price,\r\n" + //
                    "          CASE\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN\r\n" + //
                    "          'Available'\r\n" + //
                    "          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not\r\n" + //
                    "          Available'\r\n" + //
                    "          END AS isBorrow\r\n" + //
                    "          FROM Books WHERE Title = ? ORDER BY ISBN;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Title_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String ISBN = resultSet.getString("ISBN");
                    String Title = resultSet.getString("Title");
                    String Edition = resultSet.getString("Edition");
                    String Author = resultSet.getString("Author");
                    String Category = resultSet.getString("Category");
                    int Price = resultSet.getInt("Price");
                    String isBorrow = resultSet.getString("isBorrow");
                    //
                    System.out.println("ISBN: " + ISBN);
                    System.out.println("Title: " + Title);
                    System.out.println("Edition: " + Edition);
                    System.out.println("Author: " + Author);
                    System.out.println("Category: " + Category);
                    System.out.println("Price: " + Price);
                    System.out.println("isBorrow: " + isBorrow);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
         * SELECT ISBN, Title, Edition, Author, Category, Price,
         * CASE
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN
         * 'Available'
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not
         * Available'
         * END AS isBorrow
         * FROM Books WHERE Title = 'Kiem si' ORDER BY ISBN;
         */
    }

    public void List_borrowing_book() {
        System.out.println("List_borrowing_book");
        /*
         * SELECT Books.ISBN, Books.Title, Reports.date_issue,Reports.date_return,
         * CASE
         * WHEN Reports.date_return < CURDATE() THEN 'Late'
         * WHEN Reports.date_return >= CURDATE() THEN 'NOT LATE'
         * END AS IsReturnLate,
         * CASE
         * WHEN Reports.date_return < CURDATE() THEN 1000* DATEDIFF(
         * Reports.date_return,CURDATE()) + Books.Price
         * WHEN Reports.date_return >= CURDATE() THEN Books.Price
         * END AS Total_Fee
         * FROM Reports
         * INNER JOIN Books ON Reports.ISBN = Books.ISBN
         * WHERE Reports.UserID = 'SE181672'
         * ORDER BY Books.ISBN;
         */
    }

    public void List_student_borrowing_book() {
        System.out.println("List_student_borrowing_book");
        /*
         * SELECT Users.UserID, Users.Name, Users.Email, Users.Phone, Books.ISBN,
         * Books.Title, Reports.date_issue,Reports.date_return,
         * CASE
         * WHEN Reports.date_return < CURDATE() THEN 'Late'
         * WHEN Reports.date_return >= CURDATE() THEN 'NOT LATE'
         * END AS IsReturnLate,
         * CASE
         * WHEN Reports.date_return < CURDATE() THEN 1000* DATEDIFF(
         * Reports.date_return,CURDATE()) + Books.Price
         * WHEN Reports.date_return >= CURDATE() THEN Books.Price
         * END AS Total_Fee
         * FROM Users
         * INNER JOIN Reports ON Users.UserID = Reports.UserID
         * INNER JOIN Books ON Reports.ISBN = Books.ISBN
         * ORDER BY Users.UserID;
         */

    }

    public void SearchUser(String UserID_String) {
        // SELECT UserID, Name, Email, Phone, Address, DOB FROM Users WHERE UserID =
        // 'SE181672';
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT UserID, Name, Email, Phone, Address, DOB FROM Users WHERE UserID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UserID_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String UserID = resultSet.getString("UserID");
                    String Name = resultSet.getString("Name");
                    String Email = resultSet.getString("Email");
                    String Phone = resultSet.getString("Phone");
                    String Address = resultSet.getString("Address");
                    String DOB = resultSet.getString("DOB");
                    //
                    System.out.println("UserID: " + UserID);
                    System.out.println("Name: " + Name);
                    System.out.println("Email: " + Email);
                    System.out.println("Phone: " + Phone);
                    System.out.println("Address: " + Address);
                    System.out.println("DOB: " + DOB);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void SearchPublisher(String PublisherID_String) {
        try {
            Connection connection = DriverManager.getConnection(url, database_username, database_password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Publishers WHERE PublisherID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PublisherID_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No result");
                System.out.println("\nPrint ENTER to back!\n");
                sc.nextLine();
            } else {
                do {
                    String PublisherID = resultSet.getString("PublisherID");
                    String Name = resultSet.getString("Name");
                    String Email = resultSet.getString("Email");
                    String Phone = resultSet.getString("Phone");
                    String Address = resultSet.getString("Address");
                    //
                    System.out.println("PublisherID: " + PublisherID);
                    System.out.println("Name: " + Name);
                    System.out.println("Email: " + Email);
                    System.out.println("Phone: " + Phone);
                    System.out.println("Address: " + Address);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}