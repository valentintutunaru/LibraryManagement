package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LogUser {

    private static Scanner scanner = new Scanner(System.in);

    public static void logMenu() throws FileNotFoundException {
        File userFile = new File("userDb.csv");
        ArrayList<User> userDb = ReadingUser.readingUser(userFile);
        LibraryMenu.printLogUser();
        System.out.print("Please choose an option (1-3): ");
        int option;
        option = scanner.nextInt();

        switch (option) {
            case 1:
                boolean userValidation = true;
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();
                for (User user : userDb) {
                    if (user.getUsername().toLowerCase().equals(username.toLowerCase())
                            && user.getPassword().toLowerCase().equals(password.toLowerCase())) {
                        UserMenu.userMenu();
                        userValidation = false;
                    }
                }
                if (userValidation = true) {
                    System.out.println("Invalid username or password");
                }
                break;
            case 2:
                System.out.print("Please insert your first name: ");
                String firstName = scanner.next();
                System.out.print("Please insert your last name: ");
                String lastName = scanner.next();
                System.out.print("Please insert your mail address: ");
                String mailAddress = scanner.next();
                System.out.print("Please insert your username: ");
                String newUsername = scanner.next();
                System.out.print("Please insert your password: ");
                String newPassword = scanner.next();
                Library.writingUser(firstName, lastName, mailAddress, newUsername, newPassword, userFile);
                break;
            case 3:
                System.exit(0);
                break;
        }

    }
}
