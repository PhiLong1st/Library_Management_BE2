
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