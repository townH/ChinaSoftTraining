package org.homework02.demand01;

import org.homework02.utils.Utils;
import java.io.*;

public class Demand01 {

    /**
     * 返回给定文件地址的，姓名数组
     * @param filepath
     * @return
     * @throws IOException
     */
    public String[] getAllNamesFromFile(String filepath) throws IOException {
        File file = new File(filepath);
        if ( !file.exists()) return null;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String string = "";
        String tempt ;
        while ( (tempt = bufferedReader.readLine()) != null){
            // readline() 方法 不带"\n", " "。用"\t" 做分割符
            string = string + tempt + "\t";
        }
        bufferedReader.close();

        return string.split("\t");
//        return string == null ? null : string.split("\n");
    }

    /**
     * 默认单姓，并且为第一个
     * @param nameArrays
     * @return
     */
    public String[] getFamilyName(String[] nameArrays){
        if (nameArrays == null || nameArrays.length == 0) return null;

        String[] familyNames = new String[nameArrays.length];
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < nameArrays.length; i++) {
            if ( !Utils.isRepeated(familyNames, String.valueOf(nameArrays[i].charAt(0)))){
                familyNames[i] = String.valueOf(nameArrays[i].charAt(0));
                count++;
            }
        }

        String[] noRepeatedFamilyName = new String[count];
        for (int i = 0,j=0; i < familyNames.length && j < count; i++) {
            if (familyNames[i] != null){
                noRepeatedFamilyName[j] = familyNames[i];
                j++;
            }
        }

        return noRepeatedFamilyName;
    }

    public String[] getClassifyByFamilyName(String[] nameArrays){
        if (nameArrays == null || nameArrays.length == 0) return null;

        String[] familyName = this.getFamilyName(nameArrays);

        StringBuilder builder = new StringBuilder();
        String[] noRepeatedArray = new String[familyName.length];

        for (int i = 0; i < familyName.length; i++) {
            builder.delete(0, builder.length());
            builder.append(familyName[i]).append(",").append("[");

            for (int j = 0; j < nameArrays.length; j++) {
                if ( nameArrays[j] == null || "".equals(nameArrays[j])) {
                    continue;
                }

                if (familyName[i].equals(String.valueOf(nameArrays[j].charAt(0)))){
                    builder.append(nameArrays[j]).append(",");
                }

            }
            builder.delete(builder.length() - 1, builder.length());
            builder.append("]");
            noRepeatedArray[i] = builder.toString();
        }
        return noRepeatedArray;
    }
}
