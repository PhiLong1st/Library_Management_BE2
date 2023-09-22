package controller;

import model.*;
import controller.*;

public class UPDATE {
    inforInput input = new inforInput();
    SELECT select = new SELECT();

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
        /*
         * UPDATE Users
         * SET UserID = 'SE181670', Name = 'Luffy', Email = 'luffy@gmail.com', Phone =
         * '0914749064', Address = 'Quy Nhon', DOB ='2004-07-01', username = 'Luffy',
         * pass ='123'
         * WHERE UserID = 'SE181670' ;
         */
        //
    }

    public void Update_Book(String ISBN_String) {
        System.out.println("Update_Book");
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
    }

    public void Update_Publisher(String PublisherID_String) {
        System.out.println("Update_Publisher");
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
    }
}
