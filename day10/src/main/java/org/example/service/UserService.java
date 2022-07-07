package org.example.service;

import org.example.utils.Utils;

import java.sql.PseudoColumnUsage;
import java.util.Scanner;

public class UserService {

    public boolean LoginService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please your username:");
        String username = scanner.next();
        System.out.println("please your password:");
        String password = scanner.next();

        if (username == null || "".equals(username)
                || password == null
                || "".equals(password)) {
            return false;
        }
        String value = Utils.getValueFromProFile(username);

        if (password.equals(value)) return true;

        return false;
    }

    public boolean RegisterService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please your username:");
        String username = scanner.next();
        System.out.println("please your password:");
        String password = scanner.next();


        if (username == null || "".equals(username)
                || password == null
                || "".equals(password)) {

            System.out.println("username or password can't be null or empty");
            return false;
        }

        if (Utils.hasKey(username)) {
            System.out.println("username had existed!!");
            return false;
        }

        return true;
    }
}
