package ro.jademy.librarymgmt;

import java.util.ArrayList;

public class User
{
    private String userID;
    private String firstName;
    private String lastName;
    private String mailAddress;
    private String username;
    private String password;


    public User(String userID, String firstName, String lastName, String mailAddress, String userName, String password)
    {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.username = userName;
        this.password = password;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMailAddress()
    {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress)
    {
        this.mailAddress = mailAddress;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void printDetails()
    {
        System.out.println("User ID: " + userID + "\n" +
                "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n" +
                "Mail Address: " + mailAddress + "\n" +
                "Username: " + username + "\n" );
    }


    @Override
    public String toString()
    {
        return "User{" +
                "userID='" + userID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
