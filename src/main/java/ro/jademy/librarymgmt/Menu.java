package ro.jademy.librarymgmt;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Menu {


    private String[] listOfOptions;
    private String[] listOfMethodsString;
    private Method[] listOfMethods;
    private String question;

    public void setQuestion(String question) {
        this.question = question;
    }

    public Menu(String question) {

        this.question = question;

    }


    public void setListOfOptions(String... listOfOptions) {
        this.listOfOptions = listOfOptions.clone();
    }

 /*   public void setListOfMethods(String ... listOfMethodsString){
        this.listOfMethodsString = listOfMethodsString.clone();
        listOfMethods = Book.class.getMethods();
        System.out.print(listOfMethods.length);
    }

*/


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


    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(question + " " + "\n");
        int i;
        for (i = 1; i <= listOfOptions.length; i++) {
            System.out.println(i + ") " + listOfOptions[i - 1]);
        }
        int option = 0;
        boolean optionValid = false;
        System.out.print(i + ") Exit - back" + "\n\n" + "Insert option : ");
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

        sc.close();
        System.out.println("Option is " + option);
        return option;

    }




}
