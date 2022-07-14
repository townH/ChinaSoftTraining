package com.icis.mappg;

import java.util.*;

/*斗地主案例实现思路:
    1. 组装54张扑克牌
    2. 将54张牌顺序打乱
    3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
    4. 查看三人各自手中的牌（按照牌的大小排序）、底牌
    5. 手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
* */
public class MapDouDiTest {
    public static void main(String[] args) {
        // 组排
        String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A","2"};
        String[] colors = {"♠", "♥", "♣", "♦"};
        List<String> pokerList=new ArrayList<>();
        initPokers(numbers,colors,pokerList);
        pokerList.add("小王");
        pokerList.add("大王");//
        System.out.println("新牌:"+pokerList);
        // 把原始的扑克放入到map 集合中  方便后面取派
        Map<Integer,String> pokerMap=new HashMap<>();

        if(pokerList!=null && pokerList.size()>0){
            int count=0;
            for (String poker : pokerList) {
                pokerMap.put(count,poker);
                count++;
            }
        }
        // shuffle 自定义一个shuffle 洗牌方法
      /*  Collections.shuffle(pokerList);
        System.out.println("洗牌后:"+pokerList);*/
        // 发牌  三个玩家
        // 堆三个玩家手中的牌进行排序  输出
        System.out.println("=========================");
        List<Integer> shufflePokers = PokerUtils.shufflePokers(pokerList);
       // 发牌
        List<Integer> player1=new ArrayList<>();
        List<Integer> player2=new ArrayList<>();
        List<Integer> player3=new ArrayList<>();
        List<Integer> dipai=new ArrayList<>();
        int length=shufflePokers.size();
        // 发牌
        for (int i=0;i<length;i++){
            Integer pokerNunmber=shufflePokers.get(i);
            if(i<51){
                if(i%3==0){
                    player1.add(pokerNunmber);
                }else  if(i%3==1){
                    player2.add(pokerNunmber);
                }else if(i%3==2){
                    player3.add(pokerNunmber);
                }
            }else {
                dipai.add(pokerNunmber);
            }

        }
      /*  System.out.println(player1.size()+"----"+player1);
        System.out.println(player2.size()+"----"+player2);
        System.out.println(player3.size()+"----"+player3);
        System.out.println(dipai.size()+"----"+dipai);*/
      // 排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dipai);

       /* System.out.println(player1.size()+"----"+player1);
        System.out.println(player2.size()+"----"+player2);
        System.out.println(player3.size()+"----"+player3);
        System.out.println(dipai.size()+"----"+dipai);*/
       // 看牌  根据所以找牌
        showPokerList(player1,pokerMap,"玩家1");
        showPokerList(player2,pokerMap,"玩家2");
        showPokerList(player3,pokerMap,"玩家3");
        showPokerList(dipai,pokerMap,"底牌");


    }
  // JJ
    private static void showPokerList(List<Integer> numberList, Map<Integer, String> pokerMap,String roleName) {
        List<String> shuffledPokerList=new ArrayList<>();
        for (Integer pokerIndex : numberList) {
            shuffledPokerList.add(pokerMap.get(pokerIndex));
        }
        // 打印
        System.out.println(roleName);
        System.out.println(shuffledPokerList);
        System.out.println("------------------------------------------------");
    }

    private static void initPokers(String[] numbers, String[] colors, List<String> pokerList) {
        for (String number : numbers) {
            for (String color : colors) {
                // 把数字  花色 拼接到一起 放入盒子中   pokerList
                pokerList.add(number+color);
            }
        }
    }
}
