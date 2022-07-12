package org.example;

import com.sun.source.tree.ReturnTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //生成扑克
        System.out.println("生成扑克============");
        ArrayList poker = initPoker();
        System.out.println( poker);

        //模拟洗牌
        System.out.println("模拟洗牌============");
        shuffle(poker);
        System.out.println( poker);

        //根据玩家数，模拟发牌
        System.out.println("根据玩家数，模拟发牌============");

        ArrayList<ArrayList> deal = (ArrayList<ArrayList>) deal(poker, 3);
        for (ArrayList arrayList : deal) {
            System.out.println("player  :\t" + arrayList);
        }

        //对扑克进行排序
        System.out.println("对扑克进行排序============");
        for (ArrayList arrayList : deal) {
            sortPokers(arrayList);
            System.out.println("player  :\t" + arrayList);
        }
    }

    public static ArrayList initPoker(){
        ArrayList<Object> list = new ArrayList<>();
        String[] pokerColer = {"♠","♥","♣","♦"};
        String[] pokerNum = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        for (String num : pokerNum) {
            for (String color : pokerColer) {
                list.add(num + color);
            }
        }
        list.add("小王");
        list.add("大王");

        return list;
    }

    public static void shuffle(List list){
        Random random = new Random();

        for (int i = 0; i < list.size(); i++) {
            int index = random.nextInt(list.size());
            Object tempt = list.get(i);
            list.set(i,list.get(index));
            list.set(index, tempt);
        }
    }

    /**
     * 发牌
     * @param poker 要被发的牌
     * @param len   多少个玩家
     * @return      每个玩家发到的牌
     */
    public static List deal(List poker,int len){
        ArrayList<ArrayList> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new ArrayList());
        }

        for (int i = 0; i < poker.size(); i++) {
            //List 不能直接 用 = 赋值
//                            list.get( i % len) = new ArrayList<>();
            list.get( i % len).add(poker.get(i));
        }

        return list;
    }

    /**
     * 对牌进行排序
     * 本来想用规则进行排序，但是牌都只是string，而且牌的大小与string 的大小不存再规律。
     * 强行硬排会有许多 if
     *
     * 合理的想法是 给牌一个权值，这又得给牌独立成一个对象
     *
     * 最终想到的方法是：先给定一个有序数组，根据索引的大小给定牌的大小，最终只需要比较索引的大小就行
     * @param list 有序的数组
     */
    public static void sortPokers(List<String> list) {
        ArrayList arrayList = initPoker();


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              return  arrayList.indexOf(o1) - arrayList.indexOf(o2);

//                if ("大王".equals(o1)) return 1;
//                if ("大王".equals(o2)) return -1;
//
//                if ("小王".equals(o1) && !"大王".equals(o2)) return 1;
//                if ("小王".equals(o2) && !"大王".equals(o1)) return -1;
//
//
//
//
//
//                String sub01 = o1.substring(0,o1.length() - (o1.length() - 1));
//
//                Integer int01 = Integer.valueOf(sub01);
//                String sub02 = o1.substring(0, o2.length() - (o2.length() - 1));
//                Integer int02 = Integer.valueOf(sub02);
//
//
//                if (int01.compareTo(int02) > 0) {
//
//                } else if (int01.compareTo(int02) < 0) {
//
//                } else {
////                    return o1.charAt(o1.length() - 1)
//                }
//
//                return -1;
            }
        });
    }


}