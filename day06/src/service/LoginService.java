package service;

import utils.Utils;

public class LoginService {
    public void login(String username, String password) {
        if (username == null || password == null ){
            System.out.println("username or password can't be null !!!");
            return;
        }

        String value = Utils.getValueFromProFile(username);
        if (password.equals(value)){
            System.out.println("login succeed!!!");
            return ;
        }else {
            System.out.println("password is mistaked !!!");
        }
    }
}
