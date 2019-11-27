package ro.jademy.librarymgmt;
import java.lang.reflect.Method;

public class MenuTest {

    public static void method() {
        int param = 12;
        System.out.println("Method"+param);
    }

    public static void main (String [] args) {
     Menu menuTest = new Menu("blalala");
     menuTest.setListOfOptions("Yes","No","Don't know","Maybe");
     menuTest.setListOfMethods(" sdfsfs");


   //  menuTest.printMenu();


    }

}
