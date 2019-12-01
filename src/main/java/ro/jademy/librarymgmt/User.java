package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String adress;
    private String phonenumber;
    private String email;
    private String function;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public User(String userName, String password, String name, String surname, String adress, String phonenumber, String email, String function) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.email = email;
        this.function = function;


    }

    public static ArrayList<User> readingUser(File fileName) throws FileNotFoundException {
        ArrayList<User> userList = new ArrayList<>();
        String strUserName = "";
        String strPassword = "";
        String strName = "";
        String strSurname = "";
        String strAdress = "";
        String strPhonenumber = "";
        String strEmail = "";
        String strFunction = "";


        Scanner databaseScanner = new Scanner(fileName);
        databaseScanner.useDelimiter("[|\n]");
        databaseScanner.nextLine();

        while (databaseScanner.hasNext()) {

            strUserName = databaseScanner.next();
            strPassword = databaseScanner.next();
            strName = databaseScanner.next();
            strSurname = databaseScanner.next();
            strAdress = databaseScanner.next();
            strPhonenumber = databaseScanner.next();
            strEmail = databaseScanner.next();
            strFunction = databaseScanner.next();

            userList.add(new User(strUserName, strPassword, strName, strSurname, strAdress, strPhonenumber, strEmail, strFunction));

        }

        return userList;
    }

    public static ArrayList<User> writingUser (File fileName, ArrayList<User>userList) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a new user:");
        System.out.print("Username:");
        String newUserName = scanner.nextLine();
        System.out.print("Password:");
        String newUserPassword = scanner.nextLine();
        System.out.print("Name:");
        String newName = scanner.nextLine();
        System.out.print("Surname:");
        String newSurname = scanner.nextLine();
        System.out.print("Adress:");
        String newAdress = scanner.nextLine();
        System.out.print("Phone number:");
        String newPhone = scanner.nextLine();
        System.out.print("Email:");
        String newEmail = scanner.nextLine();
        System.out.print("Function:");
        String newFunction = scanner.nextLine();

        userList.add(new User(newUserName, newUserPassword, newName, newSurname, newAdress, newPhone, newEmail, newFunction));


        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, true);
            fw.write(newUserName + "|" + newUserPassword + "|" + newName + "|" + newSurname + "|" + newAdress + "|" + newPhone + "|" + newEmail + "|" + newFunction + "\n");
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }


        public static boolean userVerify(String userName, ArrayList<User> userList) {
        boolean isUser = false;
        for (User u : userList) {
            if (u.userName.equals(userName)) {
                isUser = true;
            }
        }
        return isUser;
    }

    public static boolean login(String user, String password, ArrayList<User>userList) {
        boolean isUser = false;
        boolean isPass = false;
        boolean authUser = false;

        for (User u : userList) {
            if (!isUser) {
                if (u.userName.equals(user)) {
                    isUser = true;
                    if (u.password.equals(password)) {
                        isPass = true;
                    }
                }
            }

        }

        if (isUser && isPass) {
            authUser = true;
        }
        return authUser;
    }

    public static String FunctionCall (String userName, String password, ArrayList<User>users){
        for (User u:users
             ) {
            if(u.userName.equals(userName)&&u.password.equals(password)){
                return u.getFunction();
            }
        }
        return "";
    }



}
