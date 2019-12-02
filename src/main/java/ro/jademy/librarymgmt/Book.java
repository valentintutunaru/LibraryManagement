package ro.jademy.librarymgmt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Book {

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
}
