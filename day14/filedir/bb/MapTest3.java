package com.icis.mappg;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest3 {
    public static void main(String[] args) {
        // Map key: Object value: String
        // key 是自定义对象类型  记得重写 hashCode equals 方法  实现对key 的去重
        Map<Student2,String> map=new HashMap<>();
        Student2 s1 = new Student2("樱木花道", 16);
        Student2 s2 = new Student2("赤木刚宪", 18);
        Student2 s3 = new Student2("喜洋洋", 3);
        Student2 s4 = new Student2("灰太狼", 4);
        Student2 s5 = new Student2("灰太狼", 4);

        // HashMap: 键不能重复.
        // 看键的hashCode()和equals
        // 键没有重写hashCode()默认使用对象的地址
        // 学生姓名相同并且年龄相同视为同一名学生
        // 需要重写Student2的hashCode和euqals方法
        map.put(s1, "神奈川");
        map.put(s2, "东京");
        map.put(s3, "羊村");
        map.put(s4, "狼堡");
        map.put(s5, "狼窝");

        Set<Map.Entry<Student2, String>> entries = map.entrySet();
        int count=1;
        for (Map.Entry<Student2, String> entry : entries) {
            System.out.println(count+"人物信息:");
            System.out.println(entry.getKey());
            System.out.println(count+"住址:");
            System.out.println(entry.getValue());
            count++;
            System.out.println("------------------------------------------");
        }
    }
}
