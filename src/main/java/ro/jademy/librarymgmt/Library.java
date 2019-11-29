package ro.jademy.librarymgmt;

import java.util.ArrayList;

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


    public Book searchBookByTitle (String title) {
        for (Shelf shelf : shelves) {
            for(Book b : shelf.getBooks())
                if(b.getTitle().equals(title)) return b;
        }
        return null;
    }



    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book>bookResults = new ArrayList<>();
        for (Shelf shelf : shelves) {
           for(Book b : shelf.getBooks())
               if (b.getTitle().contains(title)) bookResults.add(b);
        }
        return  bookResults;
    }



    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Shelf shelf : shelves) {
            for(Book b : shelf.getBooks())
                if (b.getAuthor().contains(author)) bookList.add(b);

        }
        return bookList;
    }

    public ArrayList<Book> searchByGenre(String genre) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Shelf shelf : shelves) {
            if (shelf.genre.contains(genre)) {
               bookList.addAll(shelf.getBooks());

        } return bookList;
    }





}



