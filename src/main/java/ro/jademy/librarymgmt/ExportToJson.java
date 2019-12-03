package ro.jademy.librarymgmt;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToJson {

    public static void export(Library l) {

        Gson gson = new Gson();
        String json = gson.toJson(l);
        writeUsingFileWriter(json);

    }

    private static void writeUsingFileWriter(String data) {
        File file = new File("config.json");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


