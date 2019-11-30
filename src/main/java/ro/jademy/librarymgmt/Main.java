package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileName = new File("Booklist_database.csv");
        ArrayList<Book> csvBooks = Library.addBooksObjFromCsvFile(fileName);
/*        int count = 1;
        for (Book csvBook : csvBooks) {
            System.out.println("Book number: " + count);
            csvBook.printDetails();
            count++;
        }*/

        ArrayList<Book> searchedBook = Library.SearchBook(csvBooks, "Patricia");
        for (Book book : searchedBook) {
            book.printDetails();
        }

/*        System.out.println("Search a book: ");
        SearchBook.readFile("Lauren Willig", fileName);
*//*        ArrayList<Book> searchedBooks = SearchBook2.SearchBook(fileName, "Led");
        for (Book searchedBook : searchedBooks) {
            searchedBook.printDetails();
        }*/
    }
}
