
package view;

import java.util.Scanner;
//
import controller.*;
import model.*;

public class User_Menu {
    Scanner sc = new Scanner(System.in);
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    UPDATE update = new UPDATE();
    TOOL tool = new TOOL();
    Staff_Menu staff_menu = new Staff_Menu();

    public void SearchBookPage() {
        int choice;
        do {
            tool.clearScreen();
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
                    System.out.print("Enter ISBN: ");
                    select.SearchBook_ISBN(input.ISBNInput());
                    break;
                }
                case 2: {
                    select.SearchBook_Author();
                    tool.delay(1000);
                    break;
                }
                case 3: {
                    select.SearchBook_Category();
                    tool.delay(1000);
                    break;
                }
                case 4: {
                    select.SearchBook_Publisher();
                    tool.delay(1000);
                    break;
                }
                case 5: {
                    select.SearchBook_Title();
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 6);

    }

}
