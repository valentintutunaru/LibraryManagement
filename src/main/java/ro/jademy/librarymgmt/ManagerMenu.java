package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMenu {

    public static void managerMenu() throws FileNotFoundException {
        Scanner scanner=new Scanner(System.in);

        boolean menuExit=false;

        //Creating arraylist of books and stocks from .CSV file

        File fileName = new File("onlineBooks_database.csv");
        File stockFile=new File("stock_database.csv");

        ArrayList<Book> bookList = LibraryFileIO.readingBook(fileName);
        ArrayList<Stock> stockList = LibraryFileIO.readingStock(stockFile);


        /*for (Stock stock : stockList) {
=======
        ArrayList<Book> bookList = LibraryFileIO.readingBook(fileName);
        ArrayList<Stock> stockList = LibraryFileIO.readingStock(stockFile);
        for (Stock stock : stockList) {
>>>>>>> 9f74db635d9694cec728c5f16718c407ede9c0d7
            System.out.println(stock.getIsbn()+" "+stock.getStock());

        }


        System.out.println(stockList.size());
        System.out.println(bookList.size());*/


        while (!menuExit) {

            LibraryMenu.printManagerMenu();

            System.out.print("Please choose an option (1-8): ");


        int option = scanner.nextInt();

            switch (option) {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                   // ListBookTable.printTableBooks(153);
                    PrintBooks.printBookTable(bookList, stockList);
                   // ListBookTable.printTableBooks(153);


                    break;

                //search for a book
                case 2:
                    System.out.print("Search for (title/author/genre/publisher/ISBN: ");
                    String filter = scanner.next();

                   // ListBookTable.printTableBooks(148);
                    PrintBooks.printBookTable(Library.searchBooks(filter, bookList));
                   // ListBookTable.printTableBooks(148);

                    break;

                //add new book
                case 3:
                    Library.writingBook(new File("onlineBooks_database.csv"), bookList);
                    String newIsbn=bookList.get(bookList.size()-1).getIsbn();
                    LibraryFileIO.writingStock(new File("stock_database.csv"),newIsbn, stockList);


               /*     for (Stock stock : stockList) {
                        System.out.println(stock.getIsbn()+" "+stock.getStock());

                    }*/



                    PrintBooks.printBookTable(bookList, stockList);
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
