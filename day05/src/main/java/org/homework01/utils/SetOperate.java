package org.homework01.utils;


public class SetOperate {

    /**
     * 取交集
     * @param arr01 第一个数组
     * @param arr02 第二个数组
     * @return 交集数组
     */
    public static String[] getIntersection(String[] arr01, String[] arr02){
        if (arr01 == null || arr01.length == 0) return null;
        if (arr02 == null || arr02.length == 0) return null;

        StringBuilder builder = new StringBuilder();

        for (String s1 : arr01) {
            if (s1 == null || " ".equals(s1) ){
                continue;
            }

            for (String s2 : arr02) {
                if ( s2 == null || " ".equals(s2)){
                    continue;
                }

                if (s1 == s2){
                    builder.append(s1).append(" ");
                }
            }
        }

        return builder.toString().split(" ");
    }


    public static String[] getUnion(String[] arr01, String[] arr02) {
        if (arr01 == null || arr01.length == 0) return arr02;
        if (arr02 == null || arr02.length == 0) return arr01;

//        String  s= Arrays.toString(arr01);
//        s = s.substring(1, s.length() - 1 );
//        s += ",";
//
//        for (String s1 : arr02) {
//            if ( !s.contains(s1)){
//                s = s + s1 + ",";
//            }
//        }
//        return s.split(",");

        StringBuilder builder = new StringBuilder();

        for (String item01 : arr01) {
            if ( item01 == null || " ".equals(item01)){
                continue;
            }

            builder.append(item01).append(" ");
        }

        for (String item02 : arr02) {
            if ( item02 == null || " ".equals(item02)){
                continue;
            }

            if ( builder.indexOf(item02) == -1){
                builder.append(item02).append(" ");
            }
        }
        return builder.toString().split(" ");
    }


    public static String[] getSubtraction(String[] minuend,String[] subtrahend){
        if (minuend == null || minuend.length == 0 ) return minuend;
        if (subtrahend == null || subtrahend.length == 0) return minuend;

        StringBuilder builder = new StringBuilder();
        for (String item : minuend) {
            if ( item == null || " ".equals(item)){
                continue;
            }
            builder.append(item).append(" ");
        }

        for (String item : subtrahend) {
            if ( item == null || " ".equals(item)){
                continue;
            }

            int index = builder.indexOf(item);
            if (index != -1) {
                builder.delete(index,index + item.length() + 1);
            }
        }
        return builder.toString().split(" ");
    }
}



