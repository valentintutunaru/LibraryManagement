package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingBook {
    public static ArrayList<Book> readingBook(File fileName) throws FileNotFoundException {
        ArrayList<Book> books = new ArrayList<>();
        Scanner bookListScanner = new Scanner(fileName);

        while (bookListScanner.hasNext()) {
            String bookDescription = bookListScanner.nextLine();
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
                books.add(newBook);
            }
        }
        return books;
    }
}