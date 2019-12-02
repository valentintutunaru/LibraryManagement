package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMenu {

    public static void managerMenu() throws FileNotFoundException {

        //Creating arraylist of books from .CSV file

        File fileName = new File("onlineBooks_database.csv");
        File stockFile=new File("stock_database.csv");
        ArrayList<Book> bookList = ReadingBooks.readingBook(fileName);
        ArrayList<Stock> stockList = ReadingStock.readingStock(stockFile);
        for (Stock stock : stockList) {
            System.out.println(stock.getIsbn()+" "+stock.getStock());

        }


        System.out.println(stockList.size());
        System.out.println(bookList.size());


        LibraryMenu.printManagerMenu();
        System.out.print("Please choose an option (1-8): ");

        Scanner scanner=new Scanner(System.in);
        int option = scanner.nextInt();


        while (option != 8) {

            switch (option) {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(bookList);
                    ListBookTable.printTableBooks(148);

                    System.out.println();
                    LibraryMenu.printManagerMenu();
                    System.out.print("Please choose an option (1-8): ");
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
                    System.out.print("\nPlease choose an option (1-8):");
                    option = scanner.nextInt();
                    break;

                //add new book
                case 3:
                    Library.writingBook(new File("onlineBooks_database.csv"), bookList);
                    String newIsbn=bookList.get(bookList.size()-1).getIsbn();
                    WritingStock.writingStock(new File("stock_database.csv"),newIsbn, stockList);
                    ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(bookList);
                    LibraryMenu.printManagerMenu();
                    System.out.print("\nPlease choose an option (1-8):");
                    option = scanner.nextInt();
                    break;

                //remove a book
                case 4:


                    LibraryMenu.printManagerMenu();
                    System.out.print("\nPlease choose an option (1-8):");
                    option = scanner.nextInt();
                    break;

                //statistics
                case 5:

                    LibraryMenu.printManagerMenu();
                    System.out.print("\nPlease choose an option (1-8):");
                    option = scanner.nextInt();
                    break;

                //borrow a book
                case 6:

                    LibraryMenu.printManagerMenu();
                    System.out.print("\nPlease choose an option (1-8):");
                    option = scanner.nextInt();
                    break;

                //return a book
                case 7:

                    LibraryMenu.printManagerMenu();
                    System.out.print("\nPlease choose an option (1-8):");
                    option = scanner.nextInt();
                    break;

                //exit
                case 8:
                    System.exit(0);


                default:
                    System.out.println("\nPlease choose an option (1-8): ");
                    option = scanner.nextInt();


            }
        }


    }

}
