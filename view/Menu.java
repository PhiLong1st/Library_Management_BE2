package view;

import java.util.Scanner;
import model.*;

public class Menu {
    public void Login() {
        Scanner sc = new Scanner(System.in);
        String username, pass, type;
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

    }
}
