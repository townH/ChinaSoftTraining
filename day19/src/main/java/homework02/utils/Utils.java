package homework02.utils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.ClosedDirectoryStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class Utils {
    public static final int PORT = 31920;
    public static InetAddress SERVER_IP;

    public static final int PICTURES = 1;
    public static final int UPLOAD = 2;
    public static final int DOWNLOAD = 3;
    public static final int EXIT = 4;

    // message -> code
    public static final int SUCCEED = 0;
    public static final int FAILED = -1;


    public static final String LOCAL_SAVE_PATH = "day19/src/pic_client";
    public static final String SERVER_SAVE_PATH = "day19/src/pic_server";
    public static final String SERVER_PIC_PATH = "day19/src/pic_server";

    static {
        try {
//            SERVER_IP = InetAddress.getLocalHost();
            SERVER_IP = InetAddress.getByName("192.168.1.58");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeStream(InputStream inputStream, OutputStream outputStream) {
        try {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void closeSocket(Socket socket) {

        try {
            if (!socket.isClosed()) socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean hasPic(String picPath) {
        if (picPath == null || "".equals(picPath)) return false;

        File file = new File(picPath);
        if ( !file.exists() || ! file.isFile()) return false;

        return true;
    }

    public static List<String> getPicList(String path){
        File file = new File(path);
        File[] files = file.listFiles((dir, name) -> {
            String suffix = name.substring(name.lastIndexOf("."));
            if (".png".equals(suffix) || ".jpg".equals(suffix) || ".jepg".equals(suffix)) {
                return true;
            }
            return false;});

        ArrayList<String> list = new ArrayList<>();
        for (File item : files) {
            list.add(item.getName());
        }
        return list;
    }

    /**
     * 处理照片重复问题
     * 再名字后面标 1，2，3序号区别处理
     * @param picName
     * @return
     */
    public static File repeatedFiles(String dir,String picName){
        File savePath = new File(dir + picName);
        File parentFile = savePath.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdirs();
        }

        int salt = 1;
        while (savePath.isFile()) {
            String name = savePath.getName();
            int index = picName.lastIndexOf(".");
            String subName = picName.substring(0,index);
            String suffix = picName.substring(index) ;

            savePath = new File(dir + subName + salt + suffix);
            salt++;
        }

        return savePath;
    }
}
