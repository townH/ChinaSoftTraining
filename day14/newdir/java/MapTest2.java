package com.icis.mappg;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
    public static void main(String[] args) {
        // 定义map key String value 自定义数据类型
        Map<String,Student> studentMap=new HashMap<>();

        Student s1 = new Student("樱木花道", 16);
        Student s2 = new Student("赤木刚宪", 18);
        Student s3 = new Student("喜洋洋", 3);
        Student s4 = new Student("灰太狼", 4);

        studentMap.put("神奈川", s1);
        studentMap.put("东京", s2);
        studentMap.put("羊村", s3);
        studentMap.put("狼堡", s4);

        // 遍历map
        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        int count=1;
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(count+"住址:");
            System.out.println(entry.getKey());
            System.out.println(count+"人物信息:");
            System.out.println(entry.getValue());
            count++;
            System.out.println("------------------------------------------");
        }
    }
}
main(String[] args) {
        // 定义map key String value 自定义数据类型
        Map<String,Student> studentMap=new HashMap<>();

        Student s1 = new Student("樱木花道", 16);
        Student s2 = new Student("赤木刚宪", 18);
        Student s3 = new Student("喜洋洋", 3);
        Student s4 = new Student("灰太狼", 4);

        studentMap.put("神奈川", s1);
        studentMap.put("东京", s2);
        studentMap.put("羊村", s3);
        studentMap.put("狼堡", s4);

        // 遍历map
        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        int count=1;
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(count+"住址:");
            System.out.println(entry.getKey());
            System.out.println(count+"人物信息:");
            System.out.