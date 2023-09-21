package view;

import java.util.Scanner;
import controller.*;
// import model.inforInput;

public class Menu {
    Scanner sc = new Scanner(System.in);

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

    public void Login() {
        String username, pass, type;
        SELECT check = new SELECT();
        do {
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
            System.out.println(username + " " + pass + " " + type);
            delay(2000);
        } while (!check.checkAccount(username, pass, type));

    }
}
