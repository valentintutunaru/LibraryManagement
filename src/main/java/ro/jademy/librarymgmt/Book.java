package ro.jademy.librarymgmt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int numberOfPages;
    private String language;
    private String genre;
    private Date borrowDate;
    private Date returnDate;
    private String link;

    public Book(String title, String author, String publisher, String isbn, int numberOfPages, String language, String genre,
                String link) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.genre = genre;
        this.link = link;

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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {return link; }

    public void setLink(String link) {this.link = link; }

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
                "Paperback: " + numberOfPages + "\n" +
                "Language: " + language + "\n" +
                "Genre: " + genre + "\n" +
                "Borrowed: " + (borrowDate == null ? "-" : FORMATTER.format(borrowDate)) + "\n" +
                "Return date: " + (returnDate == null ? "-" : FORMATTER.format(returnDate)));
    }
}
