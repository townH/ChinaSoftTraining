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
        for (int i = 0; i < nameArrays.length; i++) {
            familyNames[i] = String.valueOf(nameArrays[i].charAt(0));
        }
        return familyNames;
    }


    public String[] getClassifyByFamilyName(String[] nameArrays){
        if (nameArrays == null || nameArrays.length == 0) return null;

        String[] familyName = this.getFamilyName(nameArrays);

        //不重复姓
        String[] tempt = new String[familyName.length];
        int count = 0;
        for (int i = 0; i < familyName.length; i++) {
            if ( !Utils.isRepeated(tempt, familyName[i])){
                tempt[count] = familyName[i];
                count++;
            }
        }

        StringBuilder builder = new StringBuilder();
        String[] noRepeatedArray = new String[count];

        for (int i = 0; i < count; i++) {
            builder.delete(0, builder.length());
            builder.append(tempt[i]).append(",").append("[");

            for (int j = 0; j < nameArrays.length; j++) {
                if ( nameArrays[j] == null || "".equals(nameArrays[j])) {
                    continue;
                }

                if (tempt[i].equals(String.valueOf(nameArrays[j].charAt(0)))){
                    builder.append(nameArrays[j]).append(",");
                }

            }
            builder.delete(builder.length() - 1, builder.length());
            builder.append("]");
            noRepeatedArray[i] = builder.toString();
        }
        return noRepeatedArray;
    }




//    //String数组 中是否 重复
//    public boolean isRepeated(String[] arr,String str){
//        if (arr == null || arr.length == 0) return false;
//        if (str == null || str.length() == 0) return false;
//
//        for (String s : arr) {
//            if (str.equals(s)) return true;
//        }
//        return false;
//    }
}
