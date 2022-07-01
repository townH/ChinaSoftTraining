package org.homework01;

import org.homework01.utils.SetOperate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr01 = {"djfkf","kdjfs","fkdlfdk"};
        String[] arr02 = {"1","kdjfs","2"};
        System.out.println(Arrays.toString(SetOperate.getIntersection(arr01, arr02)));

        System.out.println("SetOperate.getUnion(arr01,arr02) = " + Arrays.toString(SetOperate.getUnion(arr01, arr01)));
        System.out.println("SetOperate.getUnion(arr01, arr02).length = " + SetOperate.getUnion(arr01, arr02).length);
        System.out.println("SetOperate.getSubtraction(arr01, arr02) = " + Arrays.toString(SetOperate.getSubtraction(arr01, arr02)));


    }
}
