package homework;

import org.homework02.demand01.Demand01;
import org.homework02.demand02.Demand02;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class homework02 {





    @Test
    public void demand01() throws IOException {
        //需求1
        String file = "day05/src/main/resources/homework02/名单.txt";
        Demand01 demand01 = new Demand01();

        String[] allNamesFromFile = demand01.getAllNamesFromFile(file);
        System.out.println("Arrays.toString(allNamesFromFile) = " + Arrays.toString(allNamesFromFile));

        String[] familyName = demand01.getFamilyName(allNamesFromFile);
        System.out.println("Arrays.toString(familyName) = " + Arrays.toString(familyName));

        String[] classifyByFamilyName = demand01.getClassifyByFamilyName(allNamesFromFile);
        System.out.println("Arrays.toString(classifyByFamilyName) = " + Arrays.toString(classifyByFamilyName));

    }
}
