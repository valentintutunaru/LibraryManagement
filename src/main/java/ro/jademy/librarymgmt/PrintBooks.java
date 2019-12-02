package ro.jademy.librarymgmt;

import java.util.ArrayList;

public class PrintBooks {

    public static void printBookTable(ArrayList<Book> bookList) {

        for (int i = 0; i < bookList.size(); i++) {

            System.out.printf("| " + (i + 1) + "." + "|" +
                    bookList.get(i).getAuthor() + "%" +
                    (30 - bookList.get(i).getAuthor().length()) + "s" +
                    bookList.get(i).getTitle() + "%" +
                    (50 - bookList.get(i).getTitle().length()) +
                    "s" + bookList.get(i).getGenre() + "%" +
                    (20 - bookList.get(i).getGenre().length()) +
                    "s" + bookList.get(i).getPublisher() + "%" +
                    (30 - bookList.get(i).getPublisher().length()) + "s" +
                    bookList.get(i).getIsbn() + "%" +
                    (15 - bookList.get(i).getIsbn().length()) + "s", "|", "|", "|", "|", "|\n");


        }
    }

}
