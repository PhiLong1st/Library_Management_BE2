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
    TOOL tool = new TOOL();
    Staff_Menu staff_menu = new Staff_Menu();
    User_Menu user_menu = new User_Menu();

    String username, pass, type;

    public boolean Login() {
        SELECT check = new SELECT();
        boolean isExists;
        do {
            // isExists = true;
            tool.clearScreen();
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
            tool.delay(2000);
        } while (!isExists);
        return type.equalsIgnoreCase("admin");
    }

    public void UserHomePage() {
        int choice;
        do {
            tool.clearScreen();
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
                    user_menu.SearchBookPage();
                    break;
                }
                case 2: {
                    update.Update_User(select.get_UserID(username));
                    System.out.println("Update successfully!!!");
                    tool.delay(1000);
                    break;
                }
                case 3: {
                    // System.out.println(username);
                    select.List_borrowing_book(select.get_UserID(username));
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 4);

    }

    public void StaffHomePage() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t1. Create");
            System.out.print("\n\t\t\t\t\t2. Search ");
            System.out.print("\n\t\t\t\t\t3. Update ");
            System.out.print("\n\t\t\t\t\t4. Delete ");
            System.out.print("\n\t\t\t\t\t5. List student borrowing book");
            System.out.print("\n\t\t\t\t\t6. Borrow/Return book");
            System.out.print("\n\t\t\t\t\t7. Exit");
            choice = input.getChoice(1, 7);
            switch (choice) {
                case 1: {
                    staff_menu.Staff_CreatePage();
                    tool.delay(1000);
                    break;
                }
                case 2: {
                    staff_menu.Staff_SearchPage();
                    tool.delay(1000);
                    break;
                }
                case 3: {
                    staff_menu.Staff_UpdatePage();
                    tool.delay(1000);
                    break;
                }
                case 4: {
                    staff_menu.Staff_DeletePage();
                    tool.delay(1000);
                    break;
                }
                case 5: {
                    select.List_student_borrowing_book();
                    tool.delay(1000);
                    break;
                }
                case 6: {
                    staff_menu.Staff_borrow_return_book();
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 7);
    }
}
