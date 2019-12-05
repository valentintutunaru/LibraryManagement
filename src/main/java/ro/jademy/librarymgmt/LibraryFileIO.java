package ro.jademy.librarymgmt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryFileIO {


    private static Scanner scanner;

    public static ArrayList<Book> readingBook(File fileName) throws FileNotFoundException {
        ArrayList<Book> bookList = new ArrayList<>();
        String strBookName = "";
        String strBookAuth = "";
        String strPublisher = "";
        String strIsbn = "";
        String strGenre = "";
        String strDescr = "";

        Scanner databaseScanner = new Scanner(fileName);
        databaseScanner.useDelimiter("[|\n]");
        //databaseScanner.nextLine();


        while (databaseScanner.hasNext()) {
            strBookAuth = databaseScanner.next();
            strBookName = databaseScanner.next();
            strGenre = databaseScanner.next();
            strPublisher = databaseScanner.next();
            strIsbn = databaseScanner.next();
            strDescr = databaseScanner.next();


            bookList.add(new Book(strBookAuth, strBookName, strGenre, strPublisher, strIsbn, strDescr));
        }

        return bookList;

    }


    public static ArrayList<Stock> readingStock(File fileName) throws FileNotFoundException {

        ArrayList<Stock> stockList = new ArrayList<>();

        String strIsbn="";
        String strStock="";


        Scanner databaseScanner = new Scanner(fileName);
        databaseScanner.useDelimiter("[|\n]");
        //databaseScanner.nextLine();

        while (databaseScanner.hasNext()) {
            strIsbn = databaseScanner.next();
            strStock= databaseScanner.next();



            stockList.add(new Stock(strIsbn, strStock));
        }

        return stockList;


    }


    public static ArrayList<User> readingUser(File fileName) throws FileNotFoundException {
        ArrayList<User> usersList = new ArrayList<>();

        //scanner.useDelimiter("[|\n]");
        Scanner scanner = new Scanner(fileName);

        while (scanner.hasNext()) {
            String userLine = scanner.nextLine();
            String[] userDetails = userLine.split(",");
            String userId = userDetails[0];
            String firstName = userDetails[1];
            String lastName = userDetails[2];
            String mailAddress = userDetails[3];
            String username = userDetails[4];
            String password = userDetails[5];
            usersList.add(new User(userId, firstName, lastName, mailAddress, username, password));
        }

        return usersList;
    }

    public static ArrayList<Stock> writingStock(File fileName, String newIsbn, ArrayList<Stock> stockList) throws FileNotFoundException {

        int defaultStock = 1;
        boolean isInList = false;


        for (Stock stock : stockList) {

            if (stock.getIsbn().equals(newIsbn)) {
                System.out.println(stock.getIsbn()+" "+stock.getStock());
                int stockUpdated=Integer.parseInt(stock.getStock());
                stockUpdated++;
                stock.setStock(Integer.toString(stockUpdated));
                isInList = true;
                String foundIsbn=stock.getIsbn();
                String newStock = stock.getStock();
                editRecord("stock_database.csv", foundIsbn, newIsbn, newStock);


                break;
                //edit csv file
            }

        }

        if (isInList) {
        } else {
            stockList.add(new Stock(newIsbn, "1"));


            //FileWriter fw = null;
            try {
                FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(newIsbn + "|" + "1");
                pw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return stockList;

    }

    public static void editRecord(String filePath, String editTerm, String newIsbn, String newStock) {

        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String isbn = "";
        String stock = "";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("[|\n]");


            while (scanner.hasNext())
            {
                isbn= scanner.next();
                stock= scanner.next();


                if (isbn.equals(editTerm))
                {
                    pw.print(newIsbn+"|"+newStock+"\n");

                }
                else
                {
                    pw.print(isbn+"|"+stock+"\n");
                }
            }
            scanner.close();
            pw.flush();
            pw.close();

            System.gc();
            oldFile.delete();


            File dump=new File(filePath);
            newFile.renameTo(dump);


        }

        catch (Exception e)

        {
            System.out.println("Error!");

        }

    }

    public ArrayList<Book> writeBookToFile(File fileName, ArrayList<Book> booklist, boolean append ) {
        FileWriter fw=null;
        try {

            fw = new FileWriter(fileName, append);
            for (Book book : booklist) {
                fw.write(book.getAuthor() + "|" + book.getTitle() + "|" + book.getGenre()+"|"+book.getPublisher()+"|"+book.getDescription());

            }
            fw.close();

        }
        catch (Exception e){
            e.printStackTrace();
    }
        return booklist;
    }

    public ArrayList<Book> writeBookToFile (File file, ArrayList<Book>bookList){
        return writeBookToFile(file,bookList,false);
    }


}
