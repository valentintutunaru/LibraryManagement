package ro.jademy.librarymgmt;

public class MenuTest {

    public static void start () {
        boolean exit = false;
        System.out.println();

        while (!exit) {
            Menu mainMenu = new Menu("Main Menu");
            mainMenu.setListOfOptions("Librarian", "Customer", "Exit");
            switch (mainMenu.printMenu()) {
                case 1 : loadLibrarianMenu();
                    break;
                case 2 : loadLibrarianMenu();
                    break;
                case 3 : exit = true;
                    break;

            }

        }


    }

    public void loadLibrarianMenu {
        System.out.println("This is the librarian menu");

    }

    public void loadCustomerMenu {
        System.out.println("This is the customer menu");
    }

}
