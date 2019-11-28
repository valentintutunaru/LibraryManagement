package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchBook {
    private static Scanner scanner;

    public static void readFile(String searchTerm, File fileName) throws FileNotFoundException {
        Book newBook = new Book();
        boolean found = false;

        try {
            scanner = new Scanner(fileName);
            scanner.useDelimiter("[,\n]");
            while (scanner.hasNext() && !found) {
                String author = scanner.next();
                String title = scanner.next();
                String genre = scanner.next();
                String publisher = scanner.next();
                String isbn = scanner.next();
                String stock = scanner.next();

                if (author.contains(searchTerm)) {
                    found = true;
                    newBook.setAuthor(author);
                    newBook.setTitle(title);
                    newBook.setGenre(genre);
                    newBook.setPublisher(publisher);
                    newBook.setIsbn(isbn);
                }
            }

            if (found) {
                newBook.printDetails();
            } else {
                System.out.println("not found");
            }
        } catch (Exception e) {
            System.out.println("not found file");
        }
    }
}
