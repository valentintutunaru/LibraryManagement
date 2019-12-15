package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserMenu
{

    public static void userMenu() throws FileNotFoundException
    {

//Creating arraylist of books from .CSV file
        Scanner scanner = new Scanner(System.in);
        boolean menuExit = false;
        File fileName = new File("onlineBooks_database.csv");
        File stockFile=new File("stock_database.csv");

        ArrayList<Book> bookList = LibraryFileIO.readingBook(fileName);
        //ArrayList<Stock> stockList = LibraryFileIO.readingStock(stockFile);

        Set<Book> bookListUniqueSet = new HashSet<Book>(bookList);
        ArrayList<Book>bookListUniq = new ArrayList<>(bookListUniqueSet);

        ArrayList<Stock> stockList = LibraryFileIO.readingStock(stockFile);
        Map<String, String> stock = new HashMap<>();
        for (Stock stock1 : stockList)
        {
            stock.put(stock1.getIsbn(), stock1.getStock());
        }

        while (!menuExit)
        {

            LibraryMenu.printUserMenu();
            System.out.print("Please choose an option (1-6): ");

            int option = scanner.nextInt();

            switch (option)
            {

                case 1:

                    //listing the book table
                    System.out.println("Here is a list with all the books in the library:");
                    Collections.sort(bookListUniq, new AuthorNameComparer());
                    PrintBooks.printBookTable(bookListUniq, (HashMap<String, String>) stock);

                    break;

                //search for a book
                case 2:
                    System.out.print("Search for (title/author/genre/publisher/ISBN: ");
                    String filter = scanner.next();
                    Collections.sort(bookListUniq, new AuthorNameComparer());
                    PrintBooks.printBookTable(Library.searchBooks(filter, bookListUniq), (HashMap<String, String>) stock);

                    break;

                //wishlist
                case 3:
                    System.out.println("Your wishlist:");
                    break;

                //book description by ISBN
                case 4:
                    System.out.print("Input ISBN: ");
                    String isbn = scanner.next();

                    Library.searchIsbn(isbn, bookList);

                    break;

                //user details
                case 5:
                    System.out.println("user details procedure");

                    break;

                //exit
                case 6:

                    //

                     menuExit=true;
                    //System.exit(0);
                    break;


                default:
                    System.out.println("\nPlease choose an option (1-6): ");
                    option = scanner.nextInt();


            }
        }


    }

}

