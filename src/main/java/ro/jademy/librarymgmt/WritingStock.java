package ro.jademy.librarymgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WritingStock {

    public static ArrayList<Stock> writingStock(File fileName, String isbn, ArrayList<Stock> stockList) throws FileNotFoundException {

        int defaultStock = 1;
        /*boolean isInList = false;

        for (Stock stock : stockList) {

            if (stock.getIsbn().equals(isbn)) {
                stock.setStock(stock.getStock() + 1);
                isInList = true;
                break;
                //edit csv file
            }
        }
        if (isInList = false) {*/
          stockList.add(new Stock(isbn, 1));

            FileWriter fw = null;
            try {
                fw = new FileWriter(fileName, true);
                fw.write(isbn + "|" + defaultStock + "\n");
                fw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        //}


        /*for (int i = 0; i < stockList.size(); i++) {
            if (stockList.get(i).getIsbn().equals(isbn)) {
                stockList.get(i).setStock(Stock.getStock() + 1);
            //edit csv file
            } else {

                stockList.add(new Stock(isbn, 1));

                FileWriter fw = null;
                try {
                    fw = new FileWriter(fileName, true);
                    fw.write(isbn + "|" + defaultStock + "\n");
                    fw.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }*/

        return stockList;

    }
}
