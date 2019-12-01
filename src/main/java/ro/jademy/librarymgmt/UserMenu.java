package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {

    public static void userMenu() throws FileNotFoundException {

//Creating arraylist of books from .CSV file

        File fileName = new File("onlineBooks_database.csv");
        ArrayList<Book> bookList = ReadingBooks.readingBook(fileName);
        LibraryMenu.printUserMenu();
        System.out.print("Please choose an option (1-6): ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        while (option != 6) {

            switch (option) {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(bookList);
                    ListBookTable.printTableBooks(148);

                    System.out.println();
                    LibraryMenu.printManagerMenu();
                    System.out.print("Please choose an option (1-6): ");
                    option = scanner.nextInt();
                    break;

                //search for a book
                case 2:
                    System.out.print("Search for (title/author/genre/publisher/ISBN: ");
                    String filter = scanner.next();

                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(Library.searchBooks(filter, bookList));
                    ListBookTable.printTableBooks(148);
                    LibraryMenu.printManagerMenu();
                    System.out.print("\nPlease choose an option (1-6):");
                    option = scanner.nextInt();
                    break;

                //wishlist
                case 3:

                    break;

                //book description
                case 4:


                    break;

                //user details
                case 5:


                    break;

                //exit
                case 6:

                    System.exit(0);
                    break;


                default:
                    System.out.println("\nPlease choose an option (1-6): ");
                    option = scanner.nextInt();


            }
        }


    }

}

