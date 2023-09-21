package model;

import java.util.Scanner;
import controller.*;

public class inforInput {
    Validator check = new Validator();
    Scanner sc = new Scanner(System.in);
    SELECT select = new SELECT();

    public int getChoice(int minn, int maxx) {// check valid choice input
        int tmp = 0;
        boolean kt;
        do {
            System.out.print("\nEnter choice: ");
            try {
                kt = true;
                tmp = sc.nextInt();
                sc.nextLine();
                if (tmp < minn || tmp > maxx) {
                    System.out.println("\nData must be between " + minn + " and " + maxx);
                    kt = false;
                }
            } catch (java.util.InputMismatchException e) {
                // TODO: handle exception
                kt = false;
                System.out.println("\nWrong data type of choice!");
                sc.nextLine();
            }
        } while (!kt);
        return tmp;
    }

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
        boolean valid = true;
        do {
            UserID = sc.nextLine();
            valid = check.validUserID(UserID);
            if (!valid) {
                System.out.println("Invalid userid input!!! ");
            }
        } while (!valid);

        return UserID;
    }

    public String StaffIDInput() {
        String StaffID = "";
        boolean valid = true;
        do {
            StaffID = sc.nextLine();
            valid = check.validStaffID(StaffID);
            if (!valid) {
                System.out.println("Invalid StaffID input!!! ");
            }
        } while (!valid);

        return StaffID;
    }

    public String EmailInput() {
        String emailString = "";
        boolean valid = true;
        do {
            emailString = sc.nextLine();
            valid = check.validEmail(emailString);
            if (!valid) {
                System.out.println("Invalid Email Input!!! ");
            }
        } while (!valid);
        return emailString;
    }

    public String PhoneInput() {
        String phoneString = "";
        boolean valid = true;
        do {
            phoneString = sc.nextLine();
            valid = check.validPhone(phoneString);
            if (!valid) {
                System.out.println("Invalid Phone Input!!! ");
            }
        } while (!valid);
        return phoneString;
    }

    public String DOBInput() {
        String dobString = "";
        boolean valid = true;
        do {
            dobString = sc.nextLine();
            valid = check.validDate(dobString);
            if (!valid) {
                System.out.println("Invalid DOB Input!!! ");
            }
        } while (!valid);
        return dobString;
    }

    public String ISBNInput() {
        String ISBN_String = "";
        boolean valid = true;
        do {
            ISBN_String = sc.nextLine();
            valid = check.validISBN(ISBN_String);
            if (!valid) {
                System.out.println("Invalid ISBN Input!!! ");
            }
        } while (!valid);
        return ISBN_String;
    }

    public String PublisherInput() {
        String Publisher_String = "";
        boolean valid = true;
        do {
            Publisher_String = sc.nextLine();
            valid = check.validPublisherID(Publisher_String);
            if (!valid) {
                System.out.println("Invalid Publisher Input!!! ");
            }
        } while (!valid);
        return Publisher_String;
    }

    public int PriceInput() {
        int price;
        boolean valid = true;
        do {
            price = sc.nextInt();
            valid = check.validPrice(price);
            if (!valid) {
                System.out.println("Invalid Price Input!!! ");
            }
        } while (!valid);
        return price;
    }
}
