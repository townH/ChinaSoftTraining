package org.homework01;

import org.homework01.utils.Utils;

public class Main {
    public static void main(String[] args) {

        String password = Utils.generatePassword(3, 3, 2);
        System.out.println("password = " + password);
        System.out.println("Utils.shuffle(Utils.generatePassword(3,3,2)) = " + Utils.shuffle(password));
    }
}