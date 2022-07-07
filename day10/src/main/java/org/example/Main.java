package org.example;

import org.example.service.HomeService;
import org.example.utils.Utils;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        if ( !Utils.hasKey("aaaa")) {
//            Utils.setProFile("aaaa", "aaaa");
//        }


        new HomeService().homeService();
    }
}