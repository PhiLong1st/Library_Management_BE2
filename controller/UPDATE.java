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
}
