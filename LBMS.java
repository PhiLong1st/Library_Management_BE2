
// import model.inforInput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import view.*;

public class LBMS {
    public static void main(String[] args) {

        Menu menuView = new Menu();
        if (menuView.Login()) {// staff
            menuView.StaffHomePage();
        } else {// user
            menuView.UserHomePage();
        }
    }
}