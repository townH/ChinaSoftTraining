package homework01;

import com.sun.source.tree.NewArrayTree;

import java.io.*;
import java.lang.invoke.VarHandle;
import java.nio.file.Files;
import java.util.Arrays;

public class FileTransfer {


    public void copyByAnByte(String fromPath,String toPath){
        if (fromPath == null || toPath == null) return;

        File fromFile = new File(fromPath);
        if ( !fromFile.exists()) {
            System.out.println("the From file is not existed");
        }

        File toFile = new File(toPath + File.separator + fromFile.getName());
        System.out.println("toFile.getName() = " + toFile.getName());

        try (
                FileOutputStream os = new FileOutputStream(toFile);
                FileInputStream is = new FileInputStream(fromFile)
        ){
            int anByte = -1;
            while ( (anByte = is.read()) != -1) {
                os.write(anByte);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void copyByAnByteReffered(String fromPath,String toPath){
        if (fromPath == null || toPath == null) return;

        File fromFile = new File(fromPath);
        if ( !fromFile.exists()) {
            System.out.println("the From file is not existed");
        }

        File toFile = new File(toPath + File.separator + fromFile.getName());
        System.out.println("toFile.getName() = " + toFile.getName());

        try (
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(toFile));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fromFile));
        ){
            int anByte = -1;
            while ((anByte = bis.read()) != -1) {
                bos.write(anByte);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void copyByByte(String fromPath,String toPath){
        if (fromPath == null || toPath == null) return;

        File fromFile = new File(fromPath);
        if ( !fromFile.exists()) {
            System.out.println("the From file is not existed");
        }

        File toFile = new File(toPath + File.separator + fromFile.getName());
        System.out.println("toFile.getName() = " + toFile.getName());

        try (
                FileOutputStream os = new FileOutputStream(toFile);
                FileInputStream is = new FileInputStream(fromFile)
        ){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void copyByByteReffered(String fromPath,String toPath){
        if (fromPath == null || toPath == null) return;

        File fromFile = new File(fromPath);
        if ( !fromFile.exists()) {
            System.out.println("the From file is not existed");
        }

        File toFile = new File(toPath + File.separator + fromFile.getName());
        System.out.println("toFile.getName() = " + toFile.getName());

        try (
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(toFile));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fromFile));
        ){
            byte[] bytes = new byte[1024];
            int len ;
            while ((len = bis.read(bytes)) != -1) {
                System.out.println(Arrays.toString(bytes));
                bos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
