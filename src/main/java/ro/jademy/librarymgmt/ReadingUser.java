package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingUser {
    private static Scanner scanner;

    public static ArrayList<User> readingUser(File fileName) throws FileNotFoundException {
        ArrayList<User> usersList = new ArrayList<>();

        //scanner = new Scanner(fileName);
        //scanner.useDelimiter("[|\n]");
        Scanner scanner = new Scanner(fileName);

        while (scanner.hasNext()) {
            String userLine = scanner.nextLine();
            String[] userDetails = userLine.split(",");
            String userId = userDetails[0];
            String firstName = userDetails[1];
            String lastName = userDetails[2];
            String mailAddress = userDetails[3];
            String username = userDetails[4];
            String password = userDetails[5];
            usersList.add(new User(userId, firstName, lastName, mailAddress, username, password));
        }

        return usersList;
    }
}
