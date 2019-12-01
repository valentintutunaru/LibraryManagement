package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("\nWelcome to the Public Library");
        Scanner scanner = new Scanner(System.in);
        boolean menuExit=false;
        File userFileName=new File("logFile.csv");
        ArrayList<User> userList=User.readingUser(userFileName);


        while (!menuExit) {
        LibraryMenu.printLibraryMenu();
        System.out.print("Please choose an option: ");
        int option = scanner.nextInt();


            switch (option) {
                case 1:
                    int count=3;
                    System.out.println("Input your username: ");
                    String userName=scanner.next();
                    if (User.userVerify(userName, userList)){
                        while (count>0){
                        System.out.println("Input your password: ");
                        String userPassword=scanner.next();
                        if (User.login(userName,userPassword,userList)) {
                            if (User.FunctionCall(userName, userPassword, userList).equalsIgnoreCase("librarian")){
                                ManagerMenu.managerMenu();
                                break;
                            }
                            System.out.println("Acces denied, your are not librarian! ");
                            System.exit(0);


                        } else {
                            System.out.println("wrong password, please input your password: ");
                            count--;
                        }
                        }
                    } else {
                        System.out.println("Inexistent user");
                        System.out.println("Do you want to create new user? (Y/N)");
                        String answer=scanner.next().toLowerCase();

                        switch (answer){
                            case "y":
                                User.writingUser(userFileName,userList);
                                break;
                            case "n":
                                System.exit(0);
                            default:
                                System.out.println("You must answer y for yes, n for no");
                        }
                    }

                    break;

                case 2:
                    UserMenu.userMenu();
                    break;

                case 3:
                    System.exit(0);
                    break;


                default:

                    System.out.print("Please choose a valid option (1-3): ");
                    option = scanner.nextInt();
            }


        }
    }
}

