package org.homework.utils;

public  class Utils {
    public static void quikSort(int[] arr,int begin,int end){
        if (begin >= end ) return;

        int mid = arr[begin];
        int i = begin;
        int j = end;

        while (i < j){
            while (arr[j] >= mid && i < j) j--;
            while (arr[i] <= mid && i < j) i++;

            if ( i < j){
                int tempt = arr[i];
                arr[i] = arr[j];
                arr[j] = tempt;
            }
        }

        arr[begin] = arr[i];
        arr[i] = mid;

        quikSort(arr, begin, i -1);
        quikSort(arr, i + 1,end);
    }
}
