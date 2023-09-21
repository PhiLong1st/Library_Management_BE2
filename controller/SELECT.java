package controller;

// import model.inforInput;
// import view.*;

public class SELECT {

    public boolean Username_isExist(String usernameString, String typeString) {
        boolean exists = true;// typeString (admin/user)
        // SELECT * FROM typeString WHERE username = 'usernameString';

        //
        return exists;
    }

    public boolean UserID_isExist(String usernameString) {
        boolean exists = true;
        // SELECT * FROM Users WHERE UserID = 'usernameString';

        //
        return exists;
    }

    public boolean checkAccount(String usernameString, String passString, String typeString) {
        boolean isGood = true;
        // check account exist in table
        if (typeString.equalsIgnoreCase("admin")) {
            //
            /*
             * 
             * SELECT * FROM Staff WHERE username = 'Sanji' AND pass = '123';
             */
            //
        } else if (typeString.equalsIgnoreCase("user")) {
            //
            /*
             * SELECT * FROM Users WHERE username = 'Luffy' AND pass = '123';
             */
            //
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

    public void SearchBook_ISBN() {
        System.out.println("SearchBook_ISBN");
        /*
         * SELECT ISBN, Title, Edition, Author, Category, Price,
         * CASE
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 0 THEN
         * 'Available'
         * WHEN EXISTS (SELECT * FROM Reports WHERE ISBN = Books.ISBN) = 1 THEN 'Not
         * Available'
         * END AS isBorrow
         * FROM Books WHERE ISBN = 'ISBN 000001' ORDER BY ISBN;
         */
    }

    public void SearchBook_Author() {
        System.out.println("SearchBook_Author");
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

    public void SearchBook_Category() {
        System.out.println("SearchBook_Category");
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

    public void SearchBook_Publisher() {
        System.out.println("SearchBook_Publisher");
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

    public void SearchBook_Title() {
        System.out.println("SearchBook_Title");
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
}
