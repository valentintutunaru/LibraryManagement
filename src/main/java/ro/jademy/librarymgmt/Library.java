package ro.jademy.librarymgmt;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static Scanner scanner;

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

    public static void addBook(String author, String name, String genre, String publisher, String isbn, File file) {
        try {
            //
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(author + "," + name + "," + genre + "," + publisher + "," + isbn);
            pw.flush();
            pw.close();

        } catch (Exception E) {
        }

    }

    public static void editBookOnCsvFile(File fileName, String editIsbn, String newPublisher) {
        String tempFile = "temp.csv";
        File newFile = new File(tempFile);
        String author = "";
        String name = "";
        String genre = "";
        String publisher = "";
        String isbn = "";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            scanner = new Scanner(fileName);
            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext()) {
                author = scanner.next();
                name = scanner.next();
                genre = scanner.next();
                publisher = scanner.next();
                isbn = scanner.next();

                if (isbn.contains(editIsbn)) {
                    pw.print(author + "," + name + "," + genre + "," + newPublisher + "," + isbn + "\n");
                } else {
                    pw.print(author + "," + name + "," + genre + "," + publisher + "," + isbn + "\n");
                }
            }
            scanner.close();
            pw.flush();
            pw.close();
            if (fileName.delete()) {
                System.out.println("done");
            } else {
                System.out.println("error");
            }
            newFile.renameTo(fileName);

        } catch (Exception e) {

        }
    }

    public static void deleteBookFromCsv(File fileName, String removeIsbn) {
        String tempFile = "removeTemp.csv";
        File newFile = new File(tempFile);
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            scanner = new Scanner(fileName);
            //scanner.useDelimiter("[,\n]");
            while (scanner.hasNext()) {
                String bookDescription = scanner.nextLine();
                String[] bookDetails = bookDescription.split(",");
                String bookAuthor = bookDetails[0];
                String bookTitle = bookDetails[1];
                String bookGenre = bookDetails[2];
                String bookPublisher = bookDetails[3];
                String bookIsbn = bookDetails[4];

               /* author = scanner.next();
                name = scanner.next();
                genre = scanner.next();
                publisher = scanner.next();
                isbn = scanner.next();*/
                //boolean check=removeIsbn.equals(isbn);
                //System.out.println(removeIsbn.equals(bookIsbn));
                if (!removeIsbn.equals(bookIsbn)) {
                    pw.print(bookAuthor + "," + bookTitle + "," + bookGenre + "," + bookPublisher + "," + bookIsbn + "\n");
                    //System.out.println(isbn);
                }
            }
            scanner.close();
            pw.close();
            pw.flush();

        } catch (Exception e) {

        }
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




