
// import model.inforInput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import view.*;

public class LBMS {
    public static void main(String[] args) {
        /*
         * 
         * Menu menuView = new Menu();
         * if (menuView.Login()) {// staff
         * menuView.StaffHomePage();
         * } else {// user
         * menuView.UserHomePage();
         * }
         */
        String url = "jdbc:mysql://localhost:3306/Library_Management_System";
        String username = "root";
        String password = "123456";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE UserID = '123'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Xử lý kết quả trả về
            if (!resultSet.next()) {
                System.out.println("Long");
            }
            while (resultSet.next()) {
                String id = resultSet.getString("UserID");
                String name = resultSet.getString("Name");
                System.out.println(id + " and  " + name);
                // ...
            }

            // Đóng tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}