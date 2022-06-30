import org.homework.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class test {
    @Test
    public void test01(){
       int[] arr =  new int[]{45, 23, 23, 12, 45, 32};
       Utils.quikSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
