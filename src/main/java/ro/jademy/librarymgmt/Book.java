package ro.jademy.librarymgmt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");


    private String author;
    private String title;
    private String genre;
    private String publisher;
    private String isbn;
    private String description;
    private Date borrowDate;
    private Date returnDate;
    private ArrayList<String> userIdList = new ArrayList<>();


    public Book(String author, String title, String genre, String publisher, String isbn, String description) {

        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description=description;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setBorrow(int days) {
        borrowDate = new Date();
        returnDate = setReturnDate(days);
    }

    public Date setReturnDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(borrowDate);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public void printDetails() {
        System.out.println("Book name is: " + title + "\n" +
                "Author: " + author + "\n"
                + "Publisher: " + publisher + "\n" +
                "ISBN: " + isbn + "\n" +
                "Genre: " + genre + "\n" +
                "Description:"+description+"\n"+
                "Borrowed: " + (borrowDate == null ? "-" : FORMATTER.format(borrowDate)) + "\n" +
                "Return date: " + (returnDate == null ? "-" : FORMATTER.format(returnDate)));
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", userIdList=" + userIdList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(description, book.description) &&
                Objects.equals(borrowDate, book.borrowDate) &&
                Objects.equals(returnDate, book.returnDate) &&
                Objects.equals(userIdList, book.userIdList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, genre, publisher, isbn, description, borrowDate, returnDate, userIdList);
    }

    @Override
    public int compareTo(Book o) {
        if(author.compareTo(o.getAuthor())==0){
            return title.compareTo(o.title);
        }
        return author.compareTo(o.author);
    }
}
