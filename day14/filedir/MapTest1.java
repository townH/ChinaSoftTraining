package com.icis.mappg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // 1.V put(K key, V value): 添加元素  存在key 修改  不存在  就是添加
        map.put("黄晓明", "Baby");
        map.put("黄晓明","李菲儿");
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("谢霆锋", "张柏芝");
        map.put("陈冠希", "张柏芝");
        System.out.println("删除前:"+map);

        // 删除  返回的是这个key 对应的value
        String removeEle = map.remove("李晨");
        System.out.println("删除后:"+map);
        System.out.println(removeEle);

        // 查询
        String value = map.get("黄晓明");
        System.out.println(value);

        //map.clear();

        //ystem.out.println(map);

        System.out.println("================map 集合遍历=====================");
        // 1. 方式1 获得所有的key 根据key 获得value
        Set<String> keys = map.keySet();
        // 2. foreach iterator
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            // 根据key获得value
            String valuec = map.get(key);
            System.out.println(key+"-----"+valuec);

        }
        System.out.println("===========================");
        // 1. 获得封装key value 的Entry 对象  优化角度讲  第二种更好点
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
           // System.out.println(entry.getClass().getName());
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
