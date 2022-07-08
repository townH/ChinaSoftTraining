package org.homework01.utils;

import java.util.*;

public class Utils {
    private static final int _LOWER_BEGIN = 'a';
    private static final int _LOWER_END = 'z';
    private static final int _UPPER_BEGIN = 'A';
    private static final int _UPPER_END = 'Z';
    private static final int _NUM_BEGIN = '0';
    private static final int _NUM_END = '9';

    public static String generatePassword(int lower,int upper,int num){
        Random random = new Random();
        char tempt;
        StringBuilder builder = new StringBuilder();
        int lowerNum = 0;
        int upperNum = 0;
        int numNum = 0;

        while( lowerNum != lower || upperNum != upper || numNum != num){
            int index = random.nextInt(3);
            if ( index == 0 && lowerNum < lower){
               tempt = generatedChar(Utils._LOWER_BEGIN,Utils._LOWER_END);
                lowerNum++;

                builder.append(tempt);
            }
            if ( index == 1 && upperNum < upper){
                tempt = generatedChar(Utils._UPPER_BEGIN,Utils._UPPER_END);
                upperNum++;
                builder.append(tempt);
            }
            if ( index == 2 && numNum < num){
                tempt = generatedChar(Utils._NUM_BEGIN,Utils._NUM_END);
                numNum++;
                builder.append(tempt);
            }

        }
        return builder.toString();
    }

    public static String  shuffle(String str){
        if (str == null) return null;
        Random random = new Random();
        int index ;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            index = random.nextInt(chars.length);

            char aChar = chars[i];
            chars[i] = chars[index];
            chars[index] = aChar;
        }
        return String.valueOf(chars);
    }

    public static char generatedChar(int begin,int end){
        Random random = new Random();
        return (char) (random.nextInt(end - begin + 1) + begin);
    }
}
