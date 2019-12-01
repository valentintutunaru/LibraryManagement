package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Shelf> shelves;
    ArrayList<Book> borrowBooks = new ArrayList<>();
    int costBorrow = 1;

    public Library(ArrayList<Shelf> shelves) {
        this.shelves = shelves;
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



    public static ArrayList<Book> writingBook (File fileName, ArrayList<Book>bookList) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a new book:");
        System.out.print("Author:");
        String newAuthor = scanner.nextLine();
        System.out.print("Title:");
        String newTitle = scanner.nextLine();
        System.out.print("Genre:");
        String newGenre = scanner.nextLine();
        System.out.print("Publisher:");
        String newPublisher = scanner.nextLine();
        System.out.print("ISBN:");
        String newISBN = scanner.nextLine();
        System.out.print("Description:");
        String newDescr = scanner.nextLine();
        bookList.add(new Book(newAuthor, newTitle, newGenre, newPublisher, newISBN, newDescr));
        PrintBooks.printBookTable(bookList);

        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, true);
            fw.write(newAuthor + "|" + newTitle + "|" + newGenre + "|" + newPublisher + "|" + newISBN + "|" + newDescr+"\n");
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return bookList;
    }



        public static ArrayList<Book> searchBooks(String filter, ArrayList<Book> bookList) {
            ArrayList<Book> searchedBooksList = new ArrayList<>();

            for (Book book : bookList) {
                if (book.getAuthor().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getTitle().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getGenre().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getPublisher().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getIsbn().contains(filter))  {
                searchedBooksList.add(book);}

            }
            return searchedBooksList;

        }

}



