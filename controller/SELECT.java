package controller;

// import model.inforInput;
// import view.*;

public class SELECT {

    public boolean Username_isExist(String usernameString) {
        boolean exists = true;
        //

        //
        return exists;
    }

    public boolean UserID_isExist(String usernameString) {
        boolean exists = true;
        //

        //
        return exists;
    }

    public boolean checkAccount(String usernameString, String passString, String typeString) {
        boolean isGood = true;
        // check account exist in table
        if (typeString.equalsIgnoreCase("admin")) {
            //

            //
        } else if (typeString.equalsIgnoreCase("user")) {
            //

            //
        } else {
            System.out.println("Input \"Admin\" or \"User\"");
            return false;
        }
        //
        if (!isGood) {
            if (!Username_isExist(usernameString)) {
                System.out.println("Account is not exists!");
            } else {
                System.out.println("Password wrong!");
            }
        } else {
            System.out.println("Login successfully!");
        }
        return isGood;
    }

    public void SearchBook_ISBN() {
        System.out.println("SearchBook_ISBN");
    }

    public void SearchBook_Author() {
        System.out.println("SearchBook_Author");
    }

    public void SearchBook_Category() {
        System.out.println("SearchBook_Category");
    }

    public void SearchBook_Publisher() {
        System.out.println("SearchBook_Publisher");
    }

    public void SearchBook_Title() {
        System.out.println("SearchBook_Title");
    }

    public void List_borrowing_book() {
        System.out.println("List_borrowing_book");
    }
}
