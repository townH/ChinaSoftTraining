package org.homework.service;


import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.homework.entity.Iphone;

import java.util.Arrays;
import java.util.Scanner;




public class IphoneService {
    public void mainService(){
        Iphone[] iphones = this.generateIphoneArr();
        System.out.println(Arrays.toString(iphones));

        quikSortIphone(iphones, 0, iphones.length - 1);
        System.out.println(Arrays.toString(iphones));

    }

    public Iphone[] generateIphoneArr() {
        Scanner scanner = new Scanner(System.in);
        Iphone[]arr = new Iphone[4];
        String input;

        for (int i = 0; i < 4 ; i++) {
            input = scanner.nextLine();

            String[] s = input.split(" ");
            Iphone iphone = new Iphone(s[0],s[1],Integer.valueOf(s[2]));
            arr[i] = iphone;
        }

        return arr;
    }

    public void quikSortIphone(Iphone[] arr,int begin,int end){
        if (begin >= end ) return;

        Iphone mid = arr[begin];
        int i = begin;
        int j = end;

        while (i < j){
            while (arr[j].getPrice() >= mid.getPrice() && i < j) j--;
            while (arr[i].getPrice() <= mid.getPrice() && i < j) i++;

            if ( i < j){
                Iphone tempt = arr[i];
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
