package service;

import entity.Goods;
import utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsService {
    List<Goods> goodsList ;

    public GoodsService() throws Exception {
        goodsList = new ArrayList<>();
        initGoods();
    }

    public void  initGoods() throws Exception {
        File file = new File(Utils._GOOD_FILE_PATH);
        if ( !file.exists() || !file.isFile()) {
            System.out.println("build goods file failed!!!");
            return ;
        }

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file))
        ){
            String row ;
            while((row = bufferedReader.readLine() )!= null){
                String[] tempt = row.split(",");
                Goods good = new Goods(tempt);
                goodsList.add(good);
            }

        }
    }

    public void printGoods(){
        System.out.println("\tid" + "\t\t\t" + "name" + "\t" + "price" + "\t" + "stock");
        goodsList.forEach((item)->{
//            System.out.println(item.getGoodsId() + "\t"
//                    + item.getName() + "\t"
//                    + item.getPrice() + "\t"
//                    + item.getStock() + "\n");
            System.out.println(item);
        });
    }


    public Goods findGoods(String goodsId){
        if (goodsId == null) return null;

        for (int i = 0; i < goodsList.size(); i++) {
            if (goodsList.get(i).getGoodsId().equals(goodsId)){
//                System.out.println(goodsList.get(i) + "=============================");
                return goodsList.get(i);
            }
        }

        return null;
    }

    public boolean subGoods(String goodsId,int num){
        if (num <= 0) return false;

        int left = -1;
        int index = -1;
        for (int i = 0; i < goodsList.size(); i++) {
            if (goodsList.get(i).getGoodsId().equals(goodsId)){
               left =  goodsList.get(i).getStock() - num;
               index = i;
               break;
            }
        }

        if (left >= 0 && index != -1) {
            goodsList.get(index).setStock(left);
            return true;
        }

        return false;
//        int index = goodsList.indexOf(goods);
//        if (index == -1) return;
//
//        Goods tempt = goodsList.get(index);
//        int remain = tempt.getStock() - num;
//        if (remain < 0) {
//            System.out.println("the number you want to buy is bigger than the stock!!! buying failed!!!");
//            return;
//        }
//        tempt.setStock(remain);
//        goodsList.set(index, tempt);
    }

    public void updataGoods() throws IOException {
        File file = new File(Utils._GOOD_FILE_PATH);
        if ( !file.exists() || !file.isFile()) {
            System.out.println("build goods file failed!!!");
            return ;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Goods goods : goodsList) {
                StringBuilder builder = new StringBuilder();
                builder.append(goods.getGoodsId()).append(",")
                        .append(goods.getName()).append(",")
                        .append(goods.getPrice()).append(",")
                        .append(goods.getStock());
                writer.write(builder.toString());
                writer.newLine();
            }
            writer.flush();
        }

    }
}
