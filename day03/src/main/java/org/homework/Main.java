package org.homework;

import org.homework.entity.Iphone;
import org.homework.service.IphoneService;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        IphoneService iphoneService = new IphoneService();
//        Iphone[] iphones = iphoneService.generateIphoneArr();
//        System.out.println(Arrays.toString(iphones));
        new IphoneService().mainService();
    }
}