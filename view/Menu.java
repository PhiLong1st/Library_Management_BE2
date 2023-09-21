package view;

import java.util.Scanner;
//
import controller.*;
import model.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    UPDATE update = new UPDATE();

    // tool
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //
    public boolean Login() {
        String username, pass, type;
        SELECT check = new SELECT();
        boolean isExists;
        do {
            // isExists = true;
            clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  LOGIN\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\tUsername: ");
            username = sc.nextLine();
            System.out.print("\t\t\t\t\tPassword: ");
            pass = sc.nextLine();
            System.out.print("\t\t\t\t\tAdmin/User: ");
            type = sc.nextLine();
            isExists = check.checkAccount(username, pass, type);
            delay(2000);
        } while (!isExists);
        return type.equalsIgnoreCase("admin");
    }

    public void SearchBookPage() {
        int choice;
        SELECT SearchBook = new SELECT();
        do {
            clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  USER\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t\tSEARCH BOOK ");
            System.out.print("\n\t\t\t\t\t1. ISBN ");
            System.out.print("\n\t\t\t\t\t2. Author ");
            System.out.print("\n\t\t\t\t\t3. Category");
            System.out.print("\n\t\t\t\t\t4. Publisher");
            System.out.print("\n\t\t\t\t\t5. Title");
            System.out.print("\n\t\t\t\t\t6. Back");
            choice = input.getChoice(1, 6);
            switch (choice) {
                case 1: {
                    SearchBook.SearchBook_ISBN();
                    delay(1000);
                    break;
                }
                case 2: {
                    SearchBook.SearchBook_Author();
                    delay(1000);
                    break;
                }
                case 3: {
                    SearchBook.SearchBook_Category();
                    delay(1000);
                    break;
                }
                case 4: {
                    SearchBook.SearchBook_Publisher();
                    delay(1000);
                    break;
                }
                case 5: {
                    SearchBook.SearchBook_Title();
                    delay(1000);
                    break;
                }
            }
        } while (choice != 6);

    }

    public void UserHomePage() {
        int choice;
        do {
            clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  USER\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t\t  MENU ");
            System.out.print("\n\t\t\t\t\t1. Search book ");
            System.out.print("\n\t\t\t\t\t2. Update information ");
            System.out.print("\n\t\t\t\t\t3. List borrowing book");
            System.out.print("\n\t\t\t\t\t4. Exit");
            choice = input.getChoice(1, 4);
            switch (choice) {
                case 1: {
                    SearchBookPage();
                    break;
                }
                case 2: {
                    boolean exist = true;
                    String UserID;
                    do {
                        System.out.print("Enter UserID: ");
                        UserID = input.UserIDInput();
                        exist = select.UserID_isExist(UserID);
                        if (!exist) {
                            System.out.println("UserID is not exist!!!");
                        }
                    } while (!exist);
                    update.Update_User(UserID);
                    System.out.println("Update successfully!!!");
                    delay(1000);
                    break;
                }
                case 3: {
                    select.List_borrowing_book();
                    delay(1000);
                    break;
                }
            }
        } while (choice != 4);

    }

    public void StaffHomePage() {
        clearScreen();
        System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
        System.out.print("\t\t\t\t\t-------------------------\n");
        System.out.print("\t\t\t\t\t\t  STAFF\n");
        System.out.print("\t\t\t\t\t-------------------------\n");
    }
}
