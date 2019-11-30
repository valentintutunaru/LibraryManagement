package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Shelf> shelves;
    ArrayList<Book> borrowBooks = new ArrayList<>();
    int costBorrow = 1;

    public Library(ArrayList<Shelf> shelves) {
        this.shelves = shelves;
    }

    public static ArrayList<Book> addBooksObjFromCsvFile(File fileName) throws FileNotFoundException {
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
            Book newBook = new Book();
            newBook.setTitle(bookTitle);
            newBook.setAuthor(bookAuthor);
            newBook.setGenre(bookGenre);
            newBook.setPublisher(bookPublisher);
            newBook.setIsbn(bookIsbn);
            books.add(newBook);
        }
        return books;
    }

    public static ArrayList<Book> SearchBook(ArrayList<Book> books, String keySearched) {
        ArrayList<Book> searchedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keySearched) || book.getAuthor().contains(keySearched)
                    || book.getGenre().contains(keySearched) || book.getPublisher().contains(keySearched)
                    || book.getIsbn().contains(keySearched)) {
                searchedBooks.add(book);
            }
        }


        return searchedBooks;
    }

    public void printBorrowedBooks() {
        for (Book lendBook : borrowBooks) {
            lendBook.printDetails();
        }
    }

    public void printShelves() {
        for (Shelf shelf : shelves) {
            System.out.println(shelf.genre);
        }
    }

    public void printLibraryBooks() {
        for (Shelf shelf : shelves) {
            shelf.printShelfBooks();
            System.out.println();
        }
    }

    public void addBook(Book book) {
        boolean createNewShelf = true;
        for (Shelf shelf : shelves) {
            if (book.getGenre().equals(shelf.genre)) {
                shelf.addBookToShelf(book);
                createNewShelf = false;
            }
        }
        if (createNewShelf) {
            ArrayList<Book> newListOfBooks = new ArrayList<>();
            newListOfBooks.add(book);
            Shelf shelf = new Shelf(newListOfBooks, book.getGenre());
            shelves.add(shelf);
        }
    }

    public void printBookByTitle(String titleOfBook) {
        for (Shelf shelf : shelves) {
            Book book = shelf.searchBook(titleOfBook);
            if (book != null) {
                book.printDetails();
            }
        }
    }

    public Book searchBookByTitle(String title) {
        for (Shelf shelf : shelves) {
            Book book = shelf.searchBook(title);
            if (book != null) {
                return book;
            }
        }
        return null;
    }

    public void searchAuthor(String author) {
        for (Shelf shelf : shelves) {
            Book book = shelf.searchAuthor(author);
            if (book != null) {
                book.printDetails();
            }
        }
    }

    public void searchGenre(String genre) {
        for (Shelf shelf : shelves) {
            if (shelf.genre.equals(genre)) {
                shelf.printShelfBooks();
            }
        }
    }

    public void removeBook(String title) {
        for (Shelf shelf : shelves) {
            shelf.removeBook(title);
        }
    }

    public void borrowBook(String title) {
        Book book = searchBookByTitle(title);
        if (book != null) {
            removeBook(book.getTitle());
            borrowBooks.add(book);
            // setam cartea ca fiind imprumutata
            book.setBorrow(15);
        }
    }
}



