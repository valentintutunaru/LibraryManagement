package ro.jademy.librarymgmt;

import java.util.Comparator;

public class AuthorNameComparer implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getAuthor().split(" ")[1].compareTo(book2.getAuthor().split(" ")[1]);
    }
}
