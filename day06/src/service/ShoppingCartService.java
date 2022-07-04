package service;

import entity.Goods;
import entity.ShoppingCart;

import java.awt.event.ItemEvent;
import java.util.Map;

public class ShoppingCartService {
    ShoppingCart shoppingCart;

    public ShoppingCartService(){
        shoppingCart = new ShoppingCart();
    }

    public void addRecord(Goods goods, int num) {
        shoppingCart.addGoods(goods, num);
    }

    public void printList(){
        System.out.println("===========buying list========\n");
        System.out.println("\tid \t" + "name \t" + "number");

        float sum = 0;
//        shoppingCart.getCart().forEach((goods,num)->{
//            System.out.println(goods.getGoodsId() + "\t" + goods.getName() + "\t" + num);
//            sum = sum + goods.getPrice() * num;
//        });
//
//        for (int i = 0; i < shoppingCart.getCart().size(); i++) {
//
//            System.out.println(goods.getGoodsId() + "\t" + goods.getName() + "\t" + num);
//            sum = sum + goods.getPrice() * num;
//        }

        for (Map.Entry<Goods, Integer> entry : shoppingCart.getCart().entrySet()) {
            System.out.println(entry.getKey().getGoodsId() + "\t" + entry.getKey().getName() + "\t" + entry.getValue());
            sum = sum + entry.getKey().getPrice() * entry.getValue();
        }

        System.out.println("\n\n" + shoppingCart.getCart().size() + "kinds of goods you had buyed");
        System.out.println("sum :\t" + sum);
    }
}
