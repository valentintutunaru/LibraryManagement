package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ManagerMenu {

    public static void managerMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        boolean menuExit = false;

        //Creating arraylist of books and stocks from .CSV file

        File fileName = new File("onlineBooks_database.csv");
        File stockFile = new File("stock_database.csv");

        ArrayList<Book> bookList = LibraryFileIO.readingBook(fileName);

        //sort books
        Collections.sort(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }









        ArrayList<Stock> stockList = LibraryFileIO.readingStock(stockFile);
        Map<String, String> stock = new HashMap<>();
        for (Stock stock1 : stockList) {
            stock.put(stock1.getIsbn(), stock1.getStock());

        }
        //System.out.println(stock);

        for (Map.Entry stockElement : stock.entrySet()) {
            System.out.println(stockElement.getKey() + " , " + stockElement.getValue());
        }


        while (!menuExit) {

            LibraryMenu.printManagerMenu();

            System.out.print("Please choose an option (1-8): ");


            int option = scanner.nextInt();

            switch (option) {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                    // ListBookTable.printTableBooks(153);
                    PrintBooks.printBookTable(bookList, (HashMap<String, String>) stock);
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
                    String newIsbn = bookList.get(bookList.size() - 1).getIsbn();
                    LibraryFileIO.writingStock(new File("stock_database.csv"), newIsbn, stockList);


               /*     for (Stock stock : stockList) {
                        System.out.println(stock.getIsbn()+" "+stock.getStock());

                    }*/


                    PrintBooks.printBookTable(bookList, (HashMap<String, String>) stock);
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
                    //save bookList in csv
                    menuExit = true;

                    break;

                default:
                    System.out.println("\nPlease choose an option (1-8): ");
                    option = scanner.nextInt();


            }
        }


    }

}
