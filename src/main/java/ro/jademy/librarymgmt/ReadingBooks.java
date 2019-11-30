package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingBooks {

    public static ArrayList<Book> readingBook (File fileName) throws FileNotFoundException {
        ArrayList<Book> bookList = new ArrayList<>();
        String strBookName = "";
        String strBookAuth = "";
        String strPublisher = "";
        String strIsbn = "";
        String strGenre = "";
        String strDescr = "";

        Scanner databaseScanner = new Scanner(fileName);
        databaseScanner.useDelimiter("[|\n]");

        while (databaseScanner.hasNext()) {
            strBookAuth = databaseScanner.next();
            strBookName = databaseScanner.next();
            strGenre = databaseScanner.next();
            strPublisher = databaseScanner.next();
            strIsbn = databaseScanner.next();
            strDescr=databaseScanner.next();


            bookList.add(new Book(strBookAuth, strBookName, strGenre, strPublisher, strIsbn, strDescr));
        }

        return bookList;



    }
}
