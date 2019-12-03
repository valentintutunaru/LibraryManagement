package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingStock {

    public static ArrayList<Stock> readingStock(File fileName) throws FileNotFoundException {

        ArrayList<Stock> stockList = new ArrayList<>();

        String strIsbn="";
        String strStock="";

        Scanner databaseScanner = new Scanner(fileName);
        databaseScanner.useDelimiter("[|\n]");

        while (databaseScanner.hasNext()) {
            strIsbn = databaseScanner.next();
            strStock=databaseScanner.next();



            stockList.add(new Stock(strIsbn, strStock));
        }

        return stockList;


    }


}
