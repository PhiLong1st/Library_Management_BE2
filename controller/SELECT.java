package controller;

// import model.inforInput;
// import view.*;

public class SELECT {

    public boolean isExist(String usernameString) {
        boolean exists = true;
        //

        //
        return exists;
    }

    public boolean checkAccount(String usernameString, String passString, String typeString) {
        boolean isGood = true;
        //

        //
        if (!isGood) {
            if (isExist(usernameString)) {
                System.out.println("Username is not exists!");
            } else {
                System.out.println("Account wrong!");
            }
        } else {
            System.out.println("Login successfully!");
        }
        return isGood;
    }
}
