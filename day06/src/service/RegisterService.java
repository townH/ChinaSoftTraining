package service;

import utils.Utils;

public class RegisterService {

    public int register(String username,String password) {
        if (username == null || "".equals(username) || username == null || "".equals(username)){
            return Utils._USER_REGISTER_FAIL;
        }

        String result = Utils.getValueFromProFile(username);
        if (result != null){
            System.out.println("username had exited !!!");
            return Utils._USER_REGISTER_FAIL;
        }

        if ( !this.judgeUsername(username)){
            System.out.println("username don't match required");
            return Utils._USER_REGISTER_FAIL;
        }
        if (!this.judgePassword(password)){
            System.out.println("password don't match required");
            return Utils._USER_REGISTER_FAIL;
    }

        Utils.setProFile(username, password);
        return Utils._USER_REGISTER_SUCCEED;
    }

    public boolean judgeUsername(String username){
        if (username == null || "".equals(username)) return false;
        
        boolean hasNum = false;
        boolean hasLetter = false;


        for (int i = 0; i < username.length(); i++) {
            if (       username.charAt(i) < '0'
                    || username.charAt(i) > '9' && username.charAt(i) < 'A'
                    || username.charAt(i) > 'Z' && username.charAt(i) < 'a'
                    || username.charAt(i) > 'z'){
                return false;
            }

            if (username.charAt(i) >= '0' && username.charAt(i) <= '9' ){
                hasNum = true;
            }

            if (username.charAt(i) >= 'A'&& username.charAt(i) <= 'Z'
                    || username.charAt(i) >= 'a'
                    || username.charAt(i) <= 'z' ){
                hasLetter = true;
            }
        }
        return hasLetter && hasLetter;
    }


    public boolean judgePassword(String password){
        if (password == null || "".equals(password)) return false;

        int digitNum = Utils.calculateCharNum(password, '0', '9');
        int lowerLetterNum = Utils.calculateCharNum(password, 'a', 'z');
        int upperLetterNum = Utils.calculateCharNum(password, 'A', 'Z');

        return digitNum == 2 && lowerLetterNum == 2 && upperLetterNum == 2;
    }

}
