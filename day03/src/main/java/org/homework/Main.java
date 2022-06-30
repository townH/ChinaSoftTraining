package org.homework;

import org.homework.service.PhoneService;

public class Main {
    public static void main(String[] args) {

//        IphoneService iphoneService = new IphoneService();
//        Iphone[] iphones = iphoneService.generateIphoneArr();
//        System.out.println(Arrays.toString(iphones));
        new PhoneService().mainService();
    }
}