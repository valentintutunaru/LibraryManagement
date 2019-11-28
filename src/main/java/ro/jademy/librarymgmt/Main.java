package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileName = new File("Booklist_database.csv");
        ArrayList<Book> csvBooks = ReadingBook.readingBook(fileName);
        int count = 1;
       /* for (Book csvBook : csvBooks) {
            if (csvBook.getGenre().equals("CHILDREN")) {
                System.out.println("Book number: " + count);
                csvBook.printDetails();
                count++;
            }
        }*/

        System.out.println("Search a book: ");
        //SearchBook.readFile("Lauren Willig", fileName);
        ArrayList<Book> searchedBooks = SearchBook2.SearchBook(fileName, "Led");
        for (Book searchedBook : searchedBooks) {
            searchedBook.printDetails();
        }
    }
}
