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
            public void executeThis (int switchNum) {
                switch(switchNum) {
                    case 1 : System.out.println("Entering librarian menu");
                    librarianMenu.loadMenu();
                    break;
                    case 2 : System.out.println("Entering customer menu");
                    break;
                    case 3 :
                    break;
                };

            }
        };

        this.librarianMenu = new Menu("This is the librarian menu", "Inventory",
                "Register new book", "Search", "Status of customer", "Main Menu") {

            @Override
            public void executeThis (int switchNum) {
                switch(switchNum) {
                    case 1 : System.out.println("Entering Inventory");
                        break;
                    case 2 : System.out.println("Register new book");
                        break;
                    case 3 : System.out.println("Search");
                        break;
                    case 4 : System.out.println("Status of customer");
                        break;
                    case 5 : System.out.println("Main menu");
                        mainMenu.loadMenu();
                        break;
                };



            }
        };
    }

    public static Scanner getSc(){
     return sc;
    }

    public void start(){

        this.sc = new Scanner(System.in);
        initMenus();
        System.out.println();
        mainMenu.loadMenu();
     }


    }



