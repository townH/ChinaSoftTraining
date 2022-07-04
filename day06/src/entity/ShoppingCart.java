package entity;

import service.ShoppingCartService;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Goods,Integer> cart;

    public ShoppingCart(){
        cart = new HashMap<>();
    }

    public int addGoods(Goods goods,int num){
//        if (num > goods.getStock() || num <= 0) return Utils._CART_FAILED;

        if (cart.containsKey(goods)){
            int sum = cart.get(goods) + num;

            cart.put(goods, cart.get(goods) + num);
            return Utils._CART_SUCCEED;
        }

        cart.put(goods,num);
        return Utils._CART_SUCCEED;
    }

    public void printGoods(){
        cart.forEach((k,v)->{
            System.out.println(k.getGoodsId() + "\t"
                    + k.getName() + "\t"
                    + k.getPrice() + "\t"
                    + v);
        });
    }

    public Map<Goods, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Goods, Integer> cart) {
        this.cart = cart;
    }
}
