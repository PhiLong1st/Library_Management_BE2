package view;

import controller.DELETE;
import controller.INSERT;
import controller.SELECT;
import controller.UPDATE;
import model.*;

public class Staff_Menu {
    TOOL tool = new TOOL();
    inforInput input = new inforInput();
    SELECT select = new SELECT();
    UPDATE update = new UPDATE();
    INSERT create = new INSERT();
    DELETE delete = new DELETE();

    public void SearchBookPage() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
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
                    System.out.print("Enter Author: ");
                    select.SearchBook_Author(input.AuthorInput());
                    tool.delay(1000);
                    break;
                }
                case 3: {
                    System.out.print("Enter Category: ");
                    select.SearchBook_Category(input.CategoryInput());
                    tool.delay(1000);
                    break;
                }
                case 4: {
                    System.out.print("Enter Publisher: ");
                    select.SearchBook_Publisher(input.PublisherInput());
                    tool.delay(1000);
                    break;
                }
                case 5: {
                    System.out.print("Enter Title: ");
                    select.SearchBook_Title(input.TitleInput());
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 6);

    }

    public void Staff_CreatePage() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  CREATE\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t1. User");
            System.out.print("\n\t\t\t\t\t2. Book");
            System.out.print("\n\t\t\t\t\t3. Publisher ");
            System.out.print("\n\t\t\t\t\t4. Back");
            choice = input.getChoice(1, 4);
            switch (choice) {
                case 1: {
                    create.Create_User();
                    tool.delay(1000);
                    break;
                }
                case 2: {
                    create.Create_Book();
                    tool.delay(1000);
                    break;
                }
                case 3: {
                    create.Create_Publisher();
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 4);
    }

    public void Staff_SearchPage() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  SEARCH\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t1. User");
            System.out.print("\n\t\t\t\t\t2. Book");
            System.out.print("\n\t\t\t\t\t3. Publisher ");
            System.out.print("\n\t\t\t\t\t4. Back");
            choice = input.getChoice(1, 4);
            switch (choice) {
                case 1: {// User
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
                    select.SearchUser(UserID);
                    tool.delay(1000);
                    break;
                }
                case 2: {// Book
                    SearchBookPage();
                    break;
                }
                case 3: {// Publisher
                    boolean exist = true;
                    String PublisherID;
                    do {
                        System.out.print("Enter PublisherID: ");
                        PublisherID = input.PublisherInput();
                        exist = select.PublisherID_isExist(PublisherID);
                        if (!exist) {
                            System.out.println("PublisherID is not exist!!!");
                        }
                    } while (!exist);
                    select.SearchPublisher(PublisherID);
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 4);
    }

    public void Staff_UpdatePage() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  UPDATE\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t1. User");
            System.out.print("\n\t\t\t\t\t2. Book");
            System.out.print("\n\t\t\t\t\t3. Publisher ");
            System.out.print("\n\t\t\t\t\t4. Back");
            choice = input.getChoice(1, 4);
            switch (choice) {
                case 1: {// User
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
                    tool.delay(1000);
                    break;
                }
                case 2: {// Book
                    boolean exist = true;
                    String ISBN;
                    do {
                        System.out.print("Enter ISBN: ");
                        ISBN = input.ISBNInput();
                        exist = select.ISBN_isExist(ISBN);
                        if (!exist) {
                            System.out.println("ISBN is not exist!!!");
                        }
                    } while (!exist);
                    update.Update_Book(ISBN);
                    System.out.println("Update successfully!!!");
                    tool.delay(1000);
                    break;
                }
                case 3: {// Publisher
                    boolean exist = true;
                    String PublisherID;
                    do {
                        System.out.print("Enter PublisherID: ");
                        PublisherID = input.PublisherInput();
                        exist = select.PublisherID_isExist(PublisherID);
                        if (!exist) {
                            System.out.println("PublisherID is not exist!!!");
                        }
                    } while (!exist);
                    update.Update_Publisher(PublisherID);
                    System.out.println("Update successfully!!!");
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 4);

    }

    public void Staff_DeletePage() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  DELETE\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t1. User");
            System.out.print("\n\t\t\t\t\t2. Book");
            System.out.print("\n\t\t\t\t\t3. Publisher ");
            System.out.print("\n\t\t\t\t\t4. Back");
            choice = input.getChoice(1, 4);
            switch (choice) {
                case 1: {
                    delete.Delete_User();
                    break;
                }
                case 2: {
                    delete.Delete_Book();
                    break;
                }
                case 3: {
                    delete.Delete_Publisher();
                    break;
                }
            }
        } while (choice != 4);
    }

    public void Staff_borrow_return_book() {
        int choice;
        do {
            tool.clearScreen();
            System.out.print("\n\n\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  STAFF\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\t\t\t\t\t\t  Borrow/Return\n");
            System.out.print("\t\t\t\t\t-------------------------\n");
            System.out.print("\n\t\t\t\t\t1. Borrow");
            System.out.print("\n\t\t\t\t\t2. Return");
            System.out.print("\n\t\t\t\t\t3. Back ");
            choice = input.getChoice(1, 3);
            switch (choice) {
                case 1: {
                    String UserID, ISBN;
                    System.out.print("Enter UserID: ");
                    UserID = input.UserIDInput();
                    System.out.print("Enter ISBN: ");
                    ISBN = input.ISBNInput();
                    if (select.isBorrowed(ISBN)) {
                        System.out.println("This book is being borrowed!!!");
                    } else {
                        create.Borrow_Book(UserID, ISBN);
                    }
                    tool.delay(1000);
                    break;
                }
                case 2: {
                    String ISBN;
                    System.out.print("Enter ISBN: ");
                    ISBN = input.ISBNInput();
                    if (!select.isBorrowed(ISBN)) {
                        System.out.println("This book is not being borrowed!!!");
                    } else {
                        delete.Return_Book(ISBN);
                    }
                    tool.delay(1000);
                    break;
                }
            }
        } while (choice != 3);
    }

}
