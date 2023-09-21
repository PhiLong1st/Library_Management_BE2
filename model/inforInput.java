package model;

import java.util.Scanner;

public class inforInput {
    Validator check = new Validator();
    Scanner sc = new Scanner(System.in);

    public String nameInput() {
        String nameString = sc.nextLine();
        return nameString;
    }

    public String addressInput() {
        String addressString = sc.nextLine();
        return addressString;
    }

    public String UserIDInput() {
        String UserID = "";
        do {
            UserID = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validUserID(UserID));
        return UserID;
    }

    public String StaffIDInput() {
        String StaffID_String = "";
        do {
            StaffID_String = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validStaffID(StaffID_String));
        return StaffID_String;
    }

    public String EmailInput() {
        String emailString = "";
        do {
            emailString = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validEmail(emailString));
        return emailString;
    }

    public String PhoneInput() {
        String phoneString = "";
        do {
            phoneString = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validPhone(phoneString));
        return phoneString;
    }

    public String DOBInput() {
        String dobString = "";
        do {
            dobString = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validDate(dobString));
        return dobString;
    }

    public String ISBNInput() {
        String ISBN_String = "";
        do {
            ISBN_String = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validISBN(ISBN_String));
        return ISBN_String;
    }

    public String PublisherInput() {
        String Publisher_String = "";
        do {
            Publisher_String = sc.nextLine();
            System.out.println("Invalid input!!! ");
        } while (!check.validPublisherID(Publisher_String));
        return Publisher_String;
    }

    public int PriceInput() {
        int price;
        do {
            price = sc.nextInt();
            System.out.println("Invalid input!!! ");
        } while (!check.validPrice(price));
        return price;
    }
}
