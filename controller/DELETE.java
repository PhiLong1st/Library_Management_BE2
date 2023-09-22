package controller;

import java.util.*;

import model.*;

public class DELETE {
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    Scanner sc = new Scanner(System.in);
    TOOL tool = new TOOL();

    public void Delete_User() {
        String UserID;
        boolean isExist = false;
        System.out.print("Enter UserID: ");
        do {
            UserID = input.UserIDInput();
            isExist = select.UserID_isExist(UserID);
            if (!isExist) {
                System.out.println("UserID is not exists!!!");
            }
        } while (!isExist);
        if (select.isBorrowingBook(UserID)) {
            System.out.println("Cannot delete because this user is borrowing book!!!");
        } else {
            //
            //
            System.out.println("Delete successfully!!!");
            tool.delay(1000);
        }
    }

    public void Delete_Book() {
        String ISBN;
        boolean isExist = false;
        System.out.print("Enter ISBN: ");
        do {
            ISBN = input.ISBNInput();
            isExist = select.ISBN_isExist(ISBN);
            if (!isExist) {
                System.out.println("ISBN is not exists!!!");
            }
        } while (!isExist);
        if (select.isBorrowed(ISBN)) {
            System.out.println("Cannot delete because this book is being borrowed!!!");
        } else {
            //
            //
            System.out.println("Delete successfully!!!");
            tool.delay(1000);

        }
    }

    public void Delete_Publisher() {
        String PublisherID;
        boolean isExist = false;
        System.out.print("Enter PublisherID: ");
        do {
            PublisherID = input.PublisherInput();
            isExist = select.PublisherID_isExist(PublisherID);
            if (!isExist) {
                System.out.println("PublisherID is not exists!!!");
            }
        } while (!isExist);
        if (select.isPublisingBook(PublisherID)) {
            System.out.println("Cannot delete because this publisher is supplying book!!!");
        } else {
            //
            //
            System.out.println("Delete successfully!!!");
            tool.delay(1000);

        }
    }
}
