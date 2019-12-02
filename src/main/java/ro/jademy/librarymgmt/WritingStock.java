package ro.jademy.librarymgmt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WritingStock {
    private static Scanner x;

    public static ArrayList<Stock> writingStock(File fileName, String newIsbn, ArrayList<Stock> stockList) throws FileNotFoundException {

        int defaultStock = 1;
        boolean isInList = false;

        for (Stock stock : stockList) {

            if (stock.getIsbn().equals(newIsbn)) {
                stock.setStock(stock.getStock() + 1);
                isInList = true;
                String foundIsbn=stock.getIsbn();
                String newStock = Integer.toString(stock.getStock());
                editRecord("stock_database.csv", foundIsbn, newStock);


                break;
                //edit csv file
            }

        }

        if (isInList) {
        } else {
            stockList.add(new Stock(newIsbn, 1));


            FileWriter fw = null;
            try {
                fw = new FileWriter(fileName, true);
                fw.write(newIsbn + "|" + defaultStock + "\n");
                fw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return stockList;

    }

    public static void editRecord(String filePath, String newIsbn, String newStock) {

        String tempFile = "stock_database.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String isbn = "";
        String stock = "";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filePath));
            x.useDelimiter("[|\n]");


            while (x.hasNext())
            {
                isbn=x.next();
                stock=x.next();


                if (isbn.equals(newIsbn))
                {
                    pw.println(newIsbn+"|"+newStock);

                }
                else
                {
                    pw.println(isbn+"|"+stock);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump=new File(filePath);
            newFile.renameTo(dump);


        }

        catch (Exception e)

        {
            System.out.println("Error!");

        }

    }
}
