package org.homework02.utils;

public class Utils {

    public static boolean isRepeated(String[] arr,String str){
        if (arr == null || arr.length == 0) return false;
        if (str == null || str.length() == 0) return false;

        for (String s : arr) {
            if (str.equals(s)) return true;
        }
        return false;
    }

    public static boolean isRepeated(int[] arr,int num){
        if ( arr.length == 0) return false;

        for (int item : arr) {
            if (num == item) return true;
        }
        return false;
    }
}
