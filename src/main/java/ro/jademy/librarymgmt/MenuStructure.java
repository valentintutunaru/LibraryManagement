package ro.jademy.librarymgmt;


import java.util.ArrayList;
import java.util.Scanner;


public class MenuStructure {


    private Menu mainMenu;
    private Menu librarianMenu;
    private Menu customerMenu;


    private static Scanner sc;


    private void initMenus() {
        this.mainMenu = new Menu("This is the main menu", "Librarian menu", "Customer menu", "Exit") {

            @Override
            public void executeThis(int switchNum) {
                switch (switchNum) {
                    case 1:
                        System.out.println("Entering librarian menu");
                        librarianMenu.loadMenu();
                        break;
                    case 2:
                        // Customer menu
                        break;
                    case 3:
                        // Exit
                        break;
                }
                ;

            }
        };

        this.librarianMenu = new Menu("This is the librarian menu", "Inventory", "Print borrowed books",
                "Register new book", "Search", "Status of customer", "Main Menu") {

            @Override
            public void executeThis(int switchNum) {
                switch (switchNum) {
                    case 1:
                        //Inventory
                        Main.getLibrary().printLibraryBooks();
                        librarianMenu.loadMenu();
                        break;
                    case 2:
                        //Print borrowed books
                        Main.getLibrary().printBorrowedBooks();
                        librarianMenu.loadMenu();
                        break;
                    case 3:
                        //Register new book
                        Menu.registerNewBook();
                        librarianMenu.loadMenu();
                        break;
                    case 4:
                        //Search
                        break;
                    case 5:
                        //Status of customers
                        for (User u : Main.getLibrary().getUserList()) u.printDetails();
                        librarianMenu.loadMenu();
                        break;
                    case 6:
                        //Main Menu
                        mainMenu.loadMenu();
                        break;
                }
                ;


            }
        };
    }


    public void start() {

        this.sc = new Scanner(System.in);
        initMenus();
        System.out.println();
        mainMenu.loadMenu();

    }


}



