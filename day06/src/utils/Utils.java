package utils;

import java.io.*;
import java.util.Calendar;
import java.util.Properties;

public class Utils {
    public final static int _CART_UNDERSTOCK = -1;
    public final static int _CART_SUCCEED= 0;
    public final static int _CART_FAILED= 1;


    public final static int _MainService_REGISTER= 1;
    public final static int _MainService_LOGIN= 2;
    public final static int _MainService_PRINT_GOODS= 3;


    public final static int _MainService_BUY_GOODS = 4;
    public final static int _MainService_PRINT_RECEIPT = 5;

    public final static int _MainService_EXIT = 6;


    public final static int _USER_REGISTER_SUCCEED= 0;
    public final static int _USER_REGISTER_FAIL= 1;



    public static String _USER_FILE_PATH = "day06/users.properties";
    public static String _GOOD_FILE_PATH = "day06/encodedGoodsItem.txt";


    public static String getValueFromProFile(String key){
        Properties properties = new Properties();
        try (
//                InputStream is = Utils.class.getClassLoader().getResourceAsStream(Utils._USER_FILE_PATH);
                InputStream input=new BufferedInputStream(new FileInputStream(Utils._USER_FILE_PATH));


        ){
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static int setProFile(String key,String value){
        Properties properties = new Properties();
        properties.setProperty(key, value);
        int result = Utils._CART_SUCCEED;

        try (
                FileWriter fileWriter = new FileWriter(Utils._USER_FILE_PATH,true);
        ){
            properties.store(fileWriter, Calendar.getInstance().getTime().toString());
        } catch (IOException e) {
            result = Utils._USER_REGISTER_FAIL;
            return result;
        }

        return result;
    }


    public static int calculateCharNum(String str,int begin,int end){
        if (str == null || begin >= end ) return 0;

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if ( str.charAt(i) >= begin && str.charAt(i) <= end){
                num++;
            }
        }
        return num;
    }

}
