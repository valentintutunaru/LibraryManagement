package ro.jademy.librarymgmt;



import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private int age;
    private int cnp;
    private List<Book> borrowedBookList = new ArrayList<>();
    private List<String> likedGenres = new ArrayList<>();

    @Override
    public String toString() {


        String borrowedBooksString = new String();
        String genreString = new String();
        String returnString = new String();

       for (String g : likedGenres) genreString += g + ' ';

       if (!borrowedBookList.isEmpty())
       for (Book b : borrowedBookList) borrowedBooksString += (" "+b.getTitle() + " by " + b.getAuthor()+'\n');
       else borrowedBooksString += " User has no borrowed books."

        returnString = "User" +
                "ID : " + id + '\n' +
                "Name : " + name + '\n' +
                "Age : " + age + '\n' +
                "CNP : " + cnp + '\n';

        if(!genreString.isEmpty())  returnString += ( "Liked genres : "+ genreString + '\n' );
        if(!borrowedBooksString.isEmpty()) returnString += ("Borrowed books :"+ borrowedBooksString + '\n');

        return returnString;

    }

    public void printDetails () {

        System.out.println(this);

    }

    public User(String name, int age, int id, int cnp, List<String> likedGenres) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.likedGenres = likedGenres;
        this.cnp = cnp;
    }



     public User(String name, int age, int id, int cnp, List<Book> borrowedBookList, List<String> likedGenres) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.cnp = cnp;
        this.likedGenres = likedGenres;
        this.borrowedBookList = borrowedBookList;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBorrowedBookList(List<Book> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLikedGenres(List<String> likedGenres) {
        this.likedGenres = likedGenres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getCnp() {
        return cnp;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

    public List<String> getLikedGenres() {
        return likedGenres;
    }

    public String getName() {
        return name;
    }

}
