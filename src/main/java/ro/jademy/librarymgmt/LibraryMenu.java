package ro.jademy.librarymgmt;

public class LibraryMenu {

    public static void printLibraryMenu() {
        System.out.println("***************************");
        System.out.println("* 1. Manager ID           *");
        System.out.println("* 2. User ID              *");
        System.out.println("* 3. EXIT                 *");
        System.out.println("***************************");
    }

    public static void printLogUser() {
        System.out.println("***************************");
        System.out.println("* 1. Sign In              *");
        System.out.println("* 2. Sign Up              *");
        System.out.println("* 3. EXIT                 *");
        System.out.println("***************************");
    }

    public static void printManagerMenu(){
        System.out.println("***************************");
        System.out.println("* 1. List the books       *");
        System.out.println("* 2. Search a book        *");
        System.out.println("* 3. Add a book           *");
        System.out.println("* 4. Remove a book        *");
        System.out.println("* 5. Statistics           *");
        System.out.println("* 6. Borrowed book        *");
        System.out.println("* 7. Return book          *");
        System.out.println("* 8. EXIT                 *");
        System.out.println("***************************");
    }
    public static void printStatisticsMenu(){
        System.out.println("***************************");
        System.out.println("* 1. Overdue books        *");
        System.out.println("* 2. Books top            *");
        System.out.println("* 2. Return               *");
        System.out.println("***************************");
    }

    public static void printUserMenu(){
        System.out.println("***************************");
        System.out.println("* 1. List the books       *");
        System.out.println("* 2. Search a book        *");
        System.out.println("* 3. Wish List            *");
        System.out.println("* 4. Book description     *");
        System.out.println("* 5. User details         *");
        System.out.println("* 6. EXIT                 *");
        System.out.println("***************************");
    }
}
