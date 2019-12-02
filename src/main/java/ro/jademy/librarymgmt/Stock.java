package ro.jademy.librarymgmt;

public class Stock {

    private String isbn;
    private int stock;


    public Stock(String isbn, int stock){

        this.isbn=isbn;
        this.stock=stock;


    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
