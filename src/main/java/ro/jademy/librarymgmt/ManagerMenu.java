package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMenu {

    public static void managerMenu() throws FileNotFoundException {
        Scanner scanner=new Scanner(System.in);

        boolean menuExit=false;

        //Creating arraylist of books from .CSV file

        File fileName = new File("onlineBooks_database.csv");
        ArrayList<Book> bookList = ReadingBooks.readingBook(fileName);

        while (!menuExit) {

            LibraryMenu.printManagerMenu();

            System.out.print("Please choose an option (1-8): ");


        int option = scanner.nextInt();

            switch (option) {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(bookList);
                    ListBookTable.printTableBooks(148);


                    break;

                //search for a book
                case 2:
                    System.out.print("Search for (title/author/genre/publisher/ISBN: ");
                    String filter = scanner.next();

                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(Library.searchBooks(filter, bookList));
                    ListBookTable.printTableBooks(148);

                    break;

                //add new book
                case 3:
                    Library.writingBook(new File("onlineBooks_database.csv"), bookList);
                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(bookList);
                    break;

                //remove a book
                case 4:


                    System.out.println("remove a book");
                    break;

                //statistics
                case 5:

                    System.out.println("statistics");
                    break;

                //borrow a book
                case 6:

                    System.out.println("borrowed book procedure");
                    break;

                //return a book
                case 7:

                    System.out.println("return book procedure");
                    break;

                //exit
                case 8:
                    // System.exit(0);
                menuExit=true;

                    break;

                default:
                    System.out.println("\nPlease choose an option (1-8): ");
                    option = scanner.nextInt();


            }
        }


    }

}
