package ro.jademy.librarymgmt;

import com.google.gson.Gson;

import java.io.*;

public class UseGson {

    public static void exportLibrary(Library l) {

        Gson gson = new Gson();
        String json = gson.toJson(l);
        writeUsingFileWriter(json);

    }

    public static Library importLibrary() {
        Gson gson = new Gson();
        String json = readUsingBufferedReader("config.json");
        return gson.fromJson(json, Library.class);


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

    private static String readUsingBufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

}


