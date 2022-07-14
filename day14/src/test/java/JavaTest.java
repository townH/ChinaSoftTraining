import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class JavaTest {

    @Test
    public void test01() throws IOException {
        File file = new File("pom.xml");
        if (file.exists()) {
            System.out.println(" exists....\" = " + " exists....");
        }
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

//        String str ;
//        while ((str = bufferedReader.readLine()) != null) {
//            System.out.println(str);
//        }

//        File parentFile = file.getParentFile();
//        if (parentFile.exists()) {
//            System.out.println("\"parentFile exists....\" = " + "parentFile exists....");
//        }

//        System.out.println("parent = " + parent);
//        String[] list = new File(parent).list();
//        System.out.println("Arrays.toString(list) = " + Arrays.toString(list));



//        FileFilter fileFilter = new FileFilter() {
//
//            @Override
//            public boolean accept(File pathname) {
//                return true;
//            }
//        };
        File filedir = new File("filedir");
        System.out.println("filedir.exists() = " + filedir.exists());
        File[] files = filedir.listFiles();
        System.out.println("Arrays.toString(files) = " + Arrays.toString(files));
    }
}
