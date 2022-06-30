package org.homework.service;


import org.homework.entity.Phone;

import java.util.Arrays;
import java.util.Scanner;




public class PhoneService {
    public void mainService(){
        Phone[] Phones = this.generateIphoneArr();
        System.out.println(Arrays.toString(Phones));

        quikSortIphone(Phones, 0, Phones.length - 1);
        System.out.println(Arrays.toString(Phones));

    }

    public Phone[] generateIphoneArr() {
        Scanner scanner = new Scanner(System.in);
        Phone[]arr = new Phone[4];
        String input;

        for (int i = 0; i < 4 ; i++) {
            input = scanner.nextLine();

            String[] s = input.split(" ");
            Phone phone = new Phone(s[0],s[1],Integer.valueOf(s[2]));
            arr[i] = phone;
        }

        return arr;
    }

    public void quikSortIphone(Phone[] arr, int begin, int end){
        if (begin >= end ) return;

        Phone mid = arr[begin];
        int i = begin;
        int j = end;

        while (i < j){
            while (arr[j].getPrice() >= mid.getPrice() && i < j) j--;
            while (arr[i].getPrice() <= mid.getPrice() && i < j) i++;

            if ( i < j){
                Phone tempt = arr[i];
                arr[i] = arr[j];
                arr[j] = tempt;
            }
        }

        arr[begin] = arr[i];
        arr[i] = mid;

        quikSortIphone(arr, begin, i -1);
        quikSortIphone(arr, i + 1,end);
    }
}
