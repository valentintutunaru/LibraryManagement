package ro.jademy.librarymgmt;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("\nWelcome to the Public Library");
        Scanner scanner = new Scanner(System.in);
        LibraryMenu.printLibraryMenu();
        System.out.print("Please choose an option: ");
        int option = scanner.nextInt();


        while (option != 3) {
            switch (option) {
                case 1:
                    ManagerMenu.managerMenu();
                    break;

                case 2:
                    UserMenu.userMenu();
                    break;

                case 3:
                    System.exit(0);
                    break;


                default:

                    System.out.print("Please choose a valid option (1-3): ");
                    option = scanner.nextInt();
            }


        }
    }
}

