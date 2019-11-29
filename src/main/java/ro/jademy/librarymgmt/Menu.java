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


    private static boolean isInteger(String strNum) {
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

        Scanner sc = MenuTest.getSc();
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
                    System.out.println("Option is valid. " + "\n");
                } else System.out.print("Number is too high or negative. Insert new option: ");
            } else System.out.print("Option is not an integer. Insert new option: ");
        }


        System.out.println("Option is " + option);
        return option;

    }


    public void executeThis(int switchNum) {

    }



    public void loadMenu() {

        executeThis(printMenu());

    }
}
