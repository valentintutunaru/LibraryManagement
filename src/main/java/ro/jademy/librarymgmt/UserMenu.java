package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {

    public static void userMenu() throws FileNotFoundException{

//Creating arraylist of books from .CSV file

        File fileName = new File("onlineBooks_database.csv");
        ArrayList<Book> bookList = ReadingBooks.readingBook(fileName);
        LibraryMenu.printUserMenu();
        System.out.print("Please choose an option (1-6): ");

        Scanner scanner=new Scanner(System.in);
        int option = scanner.nextInt();
    }
}
