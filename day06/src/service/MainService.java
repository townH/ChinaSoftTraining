package service;

import entity.Goods;
import entity.ShoppingCart;
import utils.Utils;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.security.KeyStore;
import java.util.Scanner;

public class MainService {
    GoodsService shopService;
    ShoppingCartService shoppingCartService;
    RegisterService registerService;
    GoodsService goodsService;

    LoginService loginService;


    public MainService() throws Exception {
        shopService = new GoodsService();
        shoppingCartService = new ShoppingCartService();
        registerService = new RegisterService();
        loginService = new LoginService();
        goodsService = new GoodsService();
        homePage();
    }



    public void homePage() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;


        while(true){
            System.out.println("=========欢迎使用韶关学院超市购物系统====================");
            System.out.println("1: 注册");
            System.out.println("2: 登录");
            System.out.println("3: 查看商品");
            System.out.println("4: 购买商品");
            System.out.println("5: 打印小票");
            System.out.println("6: 退出");
            System.out.println("请输入操作功能编号:");

            choose = scanner.nextInt();
            switch (choose){
                case Utils._MainService_REGISTER:
                   this.register();
                    System.out.println("\n\n");
                    break;

                case Utils._MainService_LOGIN:
                    this.login();
                    break;

                 case Utils._MainService_PRINT_GOODS:
//                     goodsService.initGoods();
                     goodsService.printGoods();
                     break;

                case Utils._MainService_BUY_GOODS:
                    this.buyGoods();
                    break;

                case Utils._MainService_PRINT_RECEIPT:
                    shoppingCartService.printList();
                    break;

                case Utils._MainService_EXIT:
                    goodsService.updataGoods();
                    System.out.println("goodbye !!!");
                    System.exit(0);
                default:
                    System.out.println(" input error !!! ");
                    continue;
            }
        }



    }


    public boolean register(){
        Scanner scanner = new Scanner(System.in);

        String username ,password;
        System.out.print("input username :\t");
        username = scanner.next();

        System.out.print("input password :\t");
        password = scanner.next();

        int result =  registerService.register(username, password);

        if (result == Utils._USER_REGISTER_SUCCEED){
            System.out.println("register succeed !!!");
            return true;
        }

        System.out.println("register failed !!!");
        return false;
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);

        String username ,password;
        System.out.print("input username :\t");
        username = scanner.next();

        System.out.print("input password :\t");
        password = scanner.next();

        loginService.login(username,password);
    }

    public void buyGoods(){
        Scanner scanner = new Scanner(System.in);
        boolean continueBuyGoods = true;
        String  choose;
        int num;

        while(continueBuyGoods){
            goodsService.printGoods();
            System.out.print("input the id you want to buy :");
            choose = scanner.next();
            System.out.print("input the number you want to buy :");
            num = scanner.nextInt();

            boolean result = goodsService.subGoods(choose, num);
            if (result){
                System.out.println("buy\t" + choose + "succeed !!!");
                shoppingCartService.addRecord(goodsService.findGoods(choose),num);
            }

            System.out.print("do you want to buy goods continue? [y / n]");
            choose = scanner.next();
            if (!"y".equals(choose)) return;
        }
    }


}
