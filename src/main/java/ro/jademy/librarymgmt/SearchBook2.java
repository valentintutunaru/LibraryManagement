package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchBook2 {
    public static ArrayList<Book> SearchBook(File fileName, String keySearch) throws FileNotFoundException {
        ArrayList<Book> searchedBooks = new ArrayList<>();
        Scanner bookListScanner = new Scanner(fileName);

        while (bookListScanner.hasNext()) {
            String bookDescription = bookListScanner.nextLine();
            if(bookDescription.contains(keySearch)) {
                String[] bookDetails = bookDescription.split(",");
                String bookAuthor = bookDetails[0];
                String bookTitle = bookDetails[1];
                String bookGenre = bookDetails[2];
                String bookPublisher = bookDetails[3];
                String bookIsbn = bookDetails[4];
                String StringBookStock = bookDetails[5];
                //int intBookStock = Integer.parseInt(StringBookStock);
                Book newBook = new Book();
                if (!bookAuthor.equals("AUTHOR")) {
                    newBook.setTitle(bookTitle);
                    newBook.setAuthor(bookAuthor);
                    newBook.setGenre(bookGenre);
                    newBook.setPublisher(bookPublisher);
                    newBook.setIsbn(bookIsbn);
                    newBook.setStock(StringBookStock);
                    searchedBooks.add(newBook);
                }
            }
        }
        return searchedBooks;
    }
}

