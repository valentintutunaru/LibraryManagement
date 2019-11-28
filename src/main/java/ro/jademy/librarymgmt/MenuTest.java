package ro.jademy.librarymgmt;


import java.util.Scanner;

public class MenuTest {


    private static Scanner sc;
    public void start() {
        this.sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println();

        while (!exit) {
            Menu mainMenu = new Menu("Main Menu");
            mainMenu.setListOfOptions("Librarian", "Customer");
            switch (mainMenu.printMenu(this.sc)) {
                case 1 : loadLibrarianMenu();
                    break;
                case 2 : loadCustomerMenu();
                    break;
                case 3 : exit = true;
                    break;

            }

        }


    }

    public void loadLibrarianMenu() {
        boolean exit = false;

        //Codul pentru fiecare functie trebuie introdus mai jos

        while(!exit) {
            Menu librarianMenu = new Menu("This is the librarian menu");
            librarianMenu.setListOfOptions("Inventory","Register new book", "Search", "Customer status");

            switch(librarianMenu.printMenu(this.sc)) {
            case 1 : System.out.println("Inventory");
            break;
            case 2 : System.out.println("Register new book");
            break;
            case 3 : System.out.println("Search");
            break;
            case 4 : System.out.println("Customer status");
            break;
            case 5 : exit =  true;
            break;
            }
        }
     this.sc.close();
    }

    public void loadCustomerMenu() {
        boolean exit = false;

        //Codul pentru fiecare functie trebuie introdus mai jos

        while(!exit) {
            Menu customerMenu = new Menu("This is the customer menu");
            customerMenu.setListOfOptions("Find a book","Borrow a book", "Status", "Return a book");

            switch(customerMenu.printMenu(this.sc)) {
                case 1 : System.out.println("Found a book");
                    break;
                case 2 : System.out.println("Borrowed a book");
                    break;
                case 3 : System.out.println("Showing status");
                    break;
                case 4 : System.out.println("Returned a book");
                    break;
                case 5 : exit =  true;
                    break;
            }
        }
    }

}
