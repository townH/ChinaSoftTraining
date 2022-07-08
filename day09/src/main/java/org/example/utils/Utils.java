package org.example.utils;

import java.io.*;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.Properties;

public class Utils {
public static final String _USER_FILE_PATH = "day10/userfile.properties";

    public static File createFile() throws IOException {
        File file = new File(_USER_FILE_PATH);

        if ( !file.exists() || !file.isFile()){
            file.createNewFile();
        }

        return file;
    }

    public static String getValueFromProFile(String key){

        Properties properties = new Properties();
        try (
//                InputStream input=new BufferedInputStream(new FileInputStream(Utils._USER_FILE_PATH));
                InputStream input=new BufferedInputStream(new FileInputStream(Utils.createFile()));
        ){
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static boolean hasKey(String key){
        if (key == null || "".equals(key)) return false;

        String value = Utils.getValueFromProFile(key);
        if (value == null) {
            return false;
        }
        return true;
    }

    public static boolean setProFile(String key,String value){
        Properties properties = new Properties();
        properties.setProperty(key, value);

        try (
                FileWriter fileWriter = new FileWriter(Utils.createFile(),true);
        ){
//            Calendar.getInstance().getTime().toString()
            properties.store(fileWriter,null);
        } catch (IOException e) {

            return false;
        }

        return true;
    }

}
