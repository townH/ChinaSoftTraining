package org.example.service;

import org.example.exception.RegisterException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeService {
    private static final int _HOME_SERVICE_LOGIN = 2;
    private static final int _HOME_SERVICE_REGISTER = 1;
    private static final int _HOME_SERVICE_LOGIN_ERROR_NUM = 3;
    private UserService userService;

    public HomeService() {
        this.userService = new UserService();
    }

    public void homeService(){
        int choose = 0;
        int loginNum = 0;

        while (true) {
            System.out.println("=========欢迎使用韶关学院超市购物系统====================");
            System.out.println("1: 注册");
            System.out.println("2: 登录");

            System.out.print("please input your choose:");
            try {
                Scanner scanner = new Scanner(System.in);
                choose = scanner.nextInt();
                if (choose < 1 || choose > 2 ) {
                   throw new RegisterException("输入范围错误 ！！！");
                }

                String username;
                String password;

                switch (choose) {
                    case _HOME_SERVICE_REGISTER :
                        register();
                        break;

                    case _HOME_SERVICE_LOGIN :
                        loginNum++;
                        login(loginNum);
                        break;
                }
            }catch(RegisterException e){
                System.out.println(e.getExceptionStr());
                if (e.getType() == RegisterException.ExceptionType.EXIST) {
                    return;
                }
//                continue;
            }catch (InputMismatchException e){
                System.out.println("input correctly please!!!");
//                continue;
            }
        }
    }

    public void register() throws RegisterException {
        boolean registResult = userService.RegisterService();
        if ( !registResult){
            throw new RegisterException("register failed !!! username has been or other reasons !!!!");
        }

        System.out.println("register succeed !!!");
    }
    public void login(int loginNum) throws RegisterException {
        boolean result = userService.LoginService();
        if ( !result && loginNum >= HomeService._HOME_SERVICE_LOGIN_ERROR_NUM){
            RegisterException registerException = new RegisterException("登录错误三次，系统自退出！！！");
            registerException.setType(RegisterException.ExceptionType.EXIST);
            throw registerException;
        }

        if ( !result ){
            throw new RegisterException("username or passwork 错误！！！");
        }

        if (result){
            System.out.println("login succeed !!!");
        }
    }
}
