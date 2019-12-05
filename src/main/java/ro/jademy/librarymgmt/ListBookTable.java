package ro.jademy.librarymgmt;

public class ListBookTable {

    public static void printTableBooks(int number) {




        String stringDashes = "";
        for (int i = 0; i < number; i++) {
            stringDashes = stringDashes + "-";
        }
        System.out.println(stringDashes);
        System.out.println("|No.|Author                       |Title                                            |Genre              |Publisher                    |ISBN        |Stock");
        System.out.println(stringDashes);
    }
}
