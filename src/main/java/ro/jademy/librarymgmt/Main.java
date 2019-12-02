package ro.jademy.librarymgmt;


import java.util.ArrayList;
import java.util.List;


public class Main {


    private static Library library;


    public static Library getLibrary() {
        return library;
    }


    public static void main(String[] args) {
        new Book("The Activity Journal", "Mrs Hinch",
                "Michael Joseph (17 Oct. 2019)", "0241426847", 288, "English",
                "Business Motivation Skills",
                "https://www.goodreads.com/book/show/47795482-mrs-hinch?from_search=true&qid=sagw5ymf4T&rank=2").addBook();
        new Book("Tall Tales and Wee Stories: The Best of Billy Connolly", "Billy Connolly",
                "Two Roads (17 Oct. 2019)", "1529361338", 336, "English",
                "Biographies",
                "https://www.goodreads.com/book/show/46851175-tall-tales-and-wee-stories?from_search=true&qid=KSSgflZoJw&rank=1").addBook();
        new Book("Crest of a Wave: My Story", "Jane McDonald",
                "Virgin Books (31 Oct. 2019)", "075355433X", 321, "English",
                "Biographies",
                "https://www.goodreads.com/book/show/46158596-crest-of-a-wave?from_search=true&qid=bocQcAgrIl&rank=7").addBook();
        new Book("I Am Watching You", "Teresa Driscoll",
                "Thomas & Mercer (1 Oct. 2017)", "9781542046596", 299, "English",
                "Thrillers",
                "https://www.goodreads.com/book/show/34879754-i-am-watching-you?from_search=true&qid=zR98Sl4uvL&rank=1").addBook();
        new Book("Don't Wake Up:", "Liz Lawler", "Twenty7 (5 Oct. 2017)", "1785770578",
                368, "English", "Psychological",
                "https://www.goodreads.com/book/show/34612420-don-t-wake-up?from_search=true&qid=eCyhGFSNU8&rank=1").addBook();
        new Book("Lolita","Vladimir Nabokov",
                "Penguin Classics (1955)", "10141182539", 200, "English",
                "Fiction","https://www.goodreads.com/book/show/7604.Lolita?from_search=true&qid=3F0SswWE9x&rank=1").addBook();
        new Book("Wuthering Heights", "Emily Bronte", "Thomas Cautley Newby(1847)",
                "10141192802",208,"English", "Fiction",
                "https://www.goodreads.com/book/show/6185.Wuthering_Heights?from_search=true&qid=SRFcMF9WIq&rank=1").addBook();
        new Book("Crime and Punishment", "Fyodor Dostoyevsky", "Penguin Classics(1977)",
                "10141192801", 250, "English", "Fiction",
                "https://www.goodreads.com/book/show/7144.Crime_and_Punishment?ac=1&from_search=true&qid=9PKwpzvDa3&rank=1").addBook();
        new Book("Anna Karenina", "Lev Tolstoi", "Russian Messenger(1877)",
                "10141192804",321, "English", "Fiction",
                "https://www.goodreads.com/book/show/15823480-anna-karenina?from_search=true&qid=V6hZ8wzeHC&rank=1").addBook();
        new Book("To Kill a Mockingbird","Harper Lee","Universal Literature(1960)",
                "10141192804",201,"English","Fiction",
                "https://www.goodreads.com/book/show/2657.To_Kill_a_Mockingbird?ac=1&from_search=true&qid=p2Na6Akkfa&rank=1").addBook();
        new Book("A Study of History","Arnold J. Toynbee","Oxford University Press(1987)",
                "10195050800",333,"English","History",
                "https://www.goodreads.com/book/show/369010.A_Study_of_History?from_search=true&qid=WqpJ5RlQoI&rank=1").addBook();
        new Book("The Making of the English Working Class","E. P. Thompson",
                "Vintage Books(1963)", "10195050820",222,"English","History",
                "https://www.goodreads.com/book/show/947848.The_Making_of_the_English_Working_Class?ac=1&from_search=true&qid=KX9D55J4kP&rank=1").addBook();
        new Book("Plagues and Peoples","William H. McNeill","New York Publisher,(1976)"
        ,"10195050830",433,"English","History",
                "https://www.goodreads.com/book/show/46725.Plagues_and_Peoples?ac=1&from_search=true&qid=MGoU6C6Qrb&rank=1").addBook();
        new Book("The Decline and Fall of the Roman Empire","Edward Gibbon",
                "Strahan & Cadell(1776)","10195050823",255,"English","History",
                "https://www.goodreads.com/book/show/19400.The_Decline_and_Fall_of_the_Roman_Empire?ac=1&from_search=true&qid=YxDZFzxIHh&rank=1").addBook();
        new Book("The Origins of The Second World War","A.J.P. Taylor",
                "Hamish Hamilton(1961)","10195050835",433,"English","History",
                "https://www.goodreads.com/book/show/22501.The_Origins_of_the_Second_World_War?ac=1&from_search=true&qid=kfqWwbObr2&rank=1").addBook();
        new Book("Business Adventures","John Brooks","John Murray Learning(2015)",
                "1473611520",234,"English","Business",
                "https://www.goodreads.com/book/show/4191136-business-adventures?from_search=true&qid=bUOpBnGiip&rank=1").addBook();


        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Shelf> shelves = new ArrayList<>();
        //Shelf shelf = new Shelf(books, book1.genre);
        library = new Library(shelves);


        ArrayList<String> genereList1 = new ArrayList<>();
        genereList1.add("Novelty");
        genereList1.add("Romance");
        ArrayList<String> genreList2 = new ArrayList<>();
        genereList1.add("SF");
        genreList2.add("History");
        User bob = new User("Bob", 20, 1, 23123, genereList1);
        User ana = new User("Ana", 16, 2, 38198, genreList2);
        library.addUser(bob);
        library.addUser(ana);

        library.borrowBook("The Activity Journal", bob);

         MenuStructure m = new MenuStructure();
         m.start();
    }
}
