package com.icis.mappg;

import java.util.*;

public class PokerUtils {
    // 定义一个洗牌的方法
    public static List<Integer> shufflePokers( List<String> pokers){
        List<Integer> shuffledPokerList=new ArrayList<>();
        // 把原始的扑克放入到map 集合中  方便后面取派
       /* Map<Integer,String> pokerMap=new HashMap<>();

        if(pokers!=null && pokers.size()>0){
            int count=0;
            for (String poker : pokers) {
                pokerMap.put(count,poker);
                count++;
            }
        }*/
        // 生成0-53 之间不重复的随机数
        Set<Integer> randNumbers=new LinkedHashSet<>();
        Random random=new Random();
        while (randNumbers.size()<54){
            int randNumber=random.nextInt(54);
            randNumbers.add(randNumber);
        }
       /* System.out.println("随机数:"+randNumbers);
        System.out.println("pokerMap:"+pokerMap);*/
       // 根据数字从map 中取出元素 放入到新的集合中
     /*   for (Integer pokerIndex : randNumbers) {
            shuffledPokerList.add(pokerMap.get(pokerIndex));
        }*/

        for (Integer number : randNumbers) {
            shuffledPokerList.add(number);
        }


        return shuffledPokerList;
    }
}
�派
       /* Map<Integer,String> pokerMap=new HashMap<>();

        if(pokers!=null && pokers.size()>0){
            int count=0;
            for (String poker : pokers) {
                pokerMap.put(count,poker);
                count++;
            }
        }*/
        // 生成0-53 之间不重复的随机数
        Set<Integer> randNumbers=new LinkedHashSet<>();
        Random random=new Random();
        while (randNumbers.size()<54){
            int randNumber=random.nextInt(54);
            randNumbers.add(randNumber);
        }
       /* System.out.println("随机数:"+randNumbers);
        System.out.println("pokerMap:"+pokerMap);*/
       // 根据数字从map 中取出�