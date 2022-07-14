package org.example;

import java.io.*;
import java.util.Map;
import java.util.*;

/**
 * @since 2022-07
 */
public class Main {
    public static final String _NEW_DIR = "day14" + File.separator + "newdir";
    public static final String _FILE_DIR = "day14" + File.separator + "filedir";
    public static final String _FILE = "day14" + File.separator + "file.txt";



    public static void main(String[] args) {
        File filedir = new File(_FILE_DIR);
        Map<String, Integer> map = new HashMap<>();
        staticsFiles(filedir,map);

        classfyFiles(filedir);

        writeMapToFile(map);
    }

    /**
     * 1. File类的list功能递归遍历filedir
     * 2. 遍历文件使用文件过滤器获得目录中有几种不同的文件格式以及文件的个数
     *    结果存储到map集合中
     *    {java:4,txt:2,doc:8}
     * @param originalFile
     * @param map
     * @return
     */
    public static Map<String,Integer> staticsFiles(File originalFile,Map<String,Integer> map){
        if (originalFile == null || !originalFile.exists()) return map;

        File[] files = originalFile.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                int index = name.lastIndexOf(".");
                if (index == -1) return map;

                String suffixName = name.substring(index + 1, name.length());
                if (map.containsKey(suffixName)) {
                    map.put(suffixName,map.get(suffixName) + 1);
//                    return map;
                }else {
                    map.put(suffixName, 1);
//                    return map;
                }
            }

            if (file.isDirectory()){
                staticsFiles(file, map);
            }
        }
        return map;
    }

    /**
     * 3.根据map 集合的 key 创建目录  例如java 目录 并把文件移动到对应的目录中
     *   复制(字节流进行文件复制)
     * @param originalFile
     */
    public static void classfyFiles(File originalFile){
        if (originalFile == null || !originalFile.exists()) return ;

        File[] files = originalFile.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                copyFiles(file);
            }

            if (file.isDirectory()){
                classfyFiles(file);
            }
        }

    }

    /**
     *  定义一个方法  把map 集合中文件和文件记录数据写入到一个文件中 要求按照从高到低写入到文件
     *    对map 集合的value 进行排序
     *     filestatus:
     *     文件类型   个数
     *     java           8
     *     doc           6
     * @param map
     */
    public static void writeMapToFile(Map map){

        //利用List数组对Map元素进行排序
        //java.utl.*  与 Java.utl.Map,是不同的Map？
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });


        System.out.println("list = " + list);
        try (
                BufferedWriter bos = new BufferedWriter(new FileWriter(_FILE));
        ){
//            for (Map.Entry<String, Integer> entry : list) {
//                bos.write(entry.getKey() + "\t" + entry.getValue());
//                bos.newLine();
//            }

            for (int i = list.size() - 1; i >= 0; i--) {
                bos.write(list.get(i).getKey() + "\t" + list.get(i).getValue());
                bos.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void copyFiles(File from) {
        File parent = new File(_NEW_DIR);
        if ( !parent.exists()) {
            parent.mkdir();
        }

        String fileName = from.getName();
        int index = fileName.lastIndexOf(".");
        String suffixName = fileName.substring( index + 1, fileName.length());
        File childDir = new File(parent,suffixName);
        if (!childDir.exists()) {
            childDir.mkdir();
        }

        try (
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(from));
                BufferedOutputStream bio = new BufferedOutputStream(new FileOutputStream( new File(childDir,from.getName()) ));
        ) {
            byte[] bytes = new byte[1024];
            while (bin.available() > 0){
                bin.read(bytes, 0, 1024);
                bio.write(bytes, 0, 1024);
            }
        } catch (Exception e) {
            System.out.println("file copy error !!");
        }
    }
}