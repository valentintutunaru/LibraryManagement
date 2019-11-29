package ro.jademy.librarymgmt;


import java.util.Scanner;
import java.util.Arrays;

public class Menu {

    private String[] listOfOptions;
    private String question;

    public Menu(String... stuff) {

        this.question = stuff[0];
        this.listOfOptions = Arrays.copyOfRange(stuff, 1, stuff.length).clone();

    }

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    private int printMenu() {

        Scanner sc = MenuStructure.getScanner();
        System.out.println(question + " " + "\n");
        int i;
        for (i = 1; i <= listOfOptions.length; i++) {
            System.out.println(i + ") " + listOfOptions[i - 1]);
        }
        int option = 0;
        boolean optionValid = false;

        while (!optionValid) {
            String optionString = sc.next();
            if (isInteger(optionString)) {
                if (Integer.parseInt(optionString) <= listOfOptions.length + 1 && Integer.parseInt(optionString) > 0) {
                    optionValid = true;
                    option = Integer.parseInt(optionString);

                } else System.out.print("Number is too high or negative. Insert new option: ");
            } else System.out.print("Option is not an integer. Insert new option: ");
        }

        return option;

    }


    public void executeThis(int switchNum) {

    }

    public static void registerNewBook () {

        Scanner sc = MenuStructure.getScanner();
        Book b = new Book();
        b.setTitle(inputString("Title : "));
        b.setAuthor(inputString("Author : "));

        //if(true) {
       if(!Main.getLibrary().searchBookByTitleAndAuthor(b.getTitle(), b.getAuthor())) {
            b.setPublisher(inputString("Publisher : "));
            b.setIsbn(inputString("Isbn :"));
            boolean optionValid = false;
            while (!optionValid) {
                System.out.print("Number of pages : ");
                String optionString = sc.next();
                if (Menu.isInteger(optionString)) {
                    if (Integer.parseInt(optionString) > 0) {
                        optionValid = true;
                        b.setNumberOfPages( Integer.parseInt(optionString));

                    } else System.out.print("Number is negative. Insert new option: ");
                } else System.out.print("Option is not an integer. Insert integer ");
            }     b.setGenre(inputString("Genre :"));
            b.setLanguage(inputString("Language :"));
            b.setLink(inputString("Link :"));
            Main.getLibrary().addBook(b);
        }
        else System.out.println("Book is already in library.");
    }

    public static String inputString (String question) {

        Scanner sc = MenuStructure.getScanner();
        System.out.print('\n'+question);
        return sc.next();
    }


    public void loadMenu() {

        executeThis(printMenu());

    }
}
