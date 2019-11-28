package ro.jademy.librarymgmt;


public class Test {



    public static void main (String [] args) {
     Menu menuTest = new Menu("blalala");
     menuTest.setListOfOptions("Yes","No","Don't know","Maybe");
   //  menuTest.printMenu();
     Review testReview = new Review("This is the first review ever!", "Andrei");
     System.out.println(testReview);

    }

}
