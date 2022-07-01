package org.homework02.demand02;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.homework02.demand01.Demand01;
import org.homework02.utils.Utils;

import java.io.IOException;
import java.util.Random;

public class Demand02 {

    public void callName(int num) throws IOException {
        if (num <= 0) return;

        Demand01 demand01 = new Demand01();
        String file = "day05/src/main/resources/homework02/名单.txt";
        String[] allNamesFromFile = demand01.getAllNamesFromFile(file);

        int[] randomNum = new int[num];
        Random random = new Random();

        int count = 0;
        while(count < num){
            int tempt = random.nextInt(allNamesFromFile.length ) ;
            if ( !Utils.isRepeated(randomNum, tempt)){
                randomNum[count] = tempt;
                count++;
            }
        }


        for (int i = 0; i < count; i++) {
            int index = randomNum[i];
            System.out.println(allNamesFromFile[index]);
        }
    }
}
