package ro.jademy.librarymgmt;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("The Activity Journal", "Mrs Hinch",
                "Michael Joseph (17 Oct. 2019)", "0241426847", 288, "English",
                "Business Motivation Skills");
        Book book2 = new Book("Tall Tales and Wee Stories: The Best of Billy Connolly", "Billy Connolly",
                "Two Roads (17 Oct. 2019)", "1529361338", 336, "English",
                "Biographies");
        Book book3 = new Book("Riding the Waves: My Story", "Jane McDonald",
                "Virgin Books (31 Oct. 2019)", "075355433X", 321, "English",
                "Biographies");
        Book book4 = new Book("I Am Watching You", "Teresa Driscoll",
                "Thomas & Mercer (1 Oct. 2017)", "9781542046596", 299, "English",
                "Thrillers");
        Book book5 = new Book("Don't Wake Up: The most gripping first chapter you will ever read!",
                "Liz Lawler", "Twenty7 (5 Oct. 2017)", "1785770578", 368,
                "English", "Psychological");
        Book book6 = new Book("Dune",
                "Frank Herbert", "Ace Books", "059309932X", 688,
                "English", "Science Fiction");
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Shelf> shelves = new ArrayList<>();
        //Shelf shelf = new Shelf(books, book1.genre);
        Library library = new Library(shelves);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        //Shelf shelf = new Shelf(books, book1.genre);
        books.add(book1);
        library.printLibraryBooks();
        System.out.println();
        System.out.println();
        System.out.println();

        //library.searchBook("Riding the Waves: My Story");
        //library.printShelves();
        //library.searchAuthor("Mrs Hinch");
        /*Book book = new Book();
        library.addBook(book);
        library.printLibraryBooks();*/
        System.out.println();
        System.out.println();
        System.out.println();
        //library.searchGenre("Biographies");
        //shelf.printShelfBooks();
        //shelf.removeBook("The Activity Journal");
        //System.out.println();
        //System.out.println();
        //shelf.printShelfBooks();
        //library.printLibraryBooks();
        //library.removeBook1("Riding the Waves: My Story");
        //library.printLibraryBooks();
        //library.printShelves();

        library.borrowBook("Riding the Waves: My Story");
//        library.printLibraryBooks();
        System.out.println("===================");
        library.printBorrowedBooks();



    }
}
