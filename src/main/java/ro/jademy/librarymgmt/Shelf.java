package ro.jademy.librarymgmt;

import java.util.ArrayList;

public class Shelf {
    ArrayList<Book> books;
    String genre;

    public Shelf(String genre) {
        this.books = new ArrayList<Book>();
        this.genre = genre;
    }

    public Shelf(ArrayList<Book> books, String genre) {
        this.books = books;
        this.genre = genre;
    }

    public void printShelfBooks() {
        System.out.println("Genre : "+ genre );
        for (Book book : books) {
            book.printDetails();
        }
    }

    public void addBookToShelf(Book book) {
        books.add(book);
    }

    public Book searchBook(String titleOfBook) {
        for (Book book : books) {
            if (book.getTitle().equals(titleOfBook)) {
                return book;
            }
        }
        return null;
    }

    public Book searchAuthor(String author) {
        for (Book book : books) {
            if (book.getTitle().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(String title) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                //book.printDetails();
                bookToRemove = book;
                break;
            }
        }
        books.remove(bookToRemove);
    }
}
