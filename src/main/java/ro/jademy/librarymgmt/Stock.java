package ro.jademy.librarymgmt;

public class Stock {

    private String isbn;
    private String stock;


    public Stock(String isbn, String stock){

        this.isbn=isbn;
        this.stock=stock;


    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
