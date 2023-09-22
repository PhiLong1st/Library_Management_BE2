package controller;

import java.util.Scanner;

import model.*;

public class INSERT {
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    Scanner sc = new Scanner(System.in);

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
            isExist = select.Username_isExist(username, "User");
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
        do {
            System.out.print("Enter PublisherID: ");
            PublisherID = input.PublisherInput();
        } while (!select.PublisherID_isExist(PublisherID));
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
    }

    public void Borrow_Book(String UserID_String, String ISBN_String) {
        System.out.println("Done!!!");
    }

    public void Return_Book(String ISBN_String) {
        System.out.println("aaaaDone!!!");
    }
}
