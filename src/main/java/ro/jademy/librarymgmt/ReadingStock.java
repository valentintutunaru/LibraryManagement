package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingStock {

    public static ArrayList<Stock> readingStock(File fileName) throws FileNotFoundException {

        ArrayList<Stock> stockList = new ArrayList<>();

        String strIsbn = "";
        int intStock;

        Scanner databaseScanner = new Scanner(fileName);
        databaseScanner.useDelimiter("[|\n]");

        while (databaseScanner.hasNext()) {
            strIsbn = databaseScanner.next();
            intStock=Integer.parseInt(databaseScanner.next());



            stockList.add(new Stock(strIsbn, intStock));
        }

        return stockList;


    }


}
