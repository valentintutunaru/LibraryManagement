package ro.jademy.librarymgmt;


public class MenuTest {



    public static void main (String [] args) {
     Menu menuTest = new Menu("blalala");
     menuTest.setListOfOptions("Yes","No","Don't know","Maybe");
     menuTest.printMenu();

    }

}
