package homework01;

public class Main {
    public static final String File_PATH = "Z:\\history\\study\\计算机综合\\算法\\视频\\01 动态规划 01【吾爱课程www.52kc.net】.mp4";
//    public static final String File_PATH = "M:\\03_study\\01_computer\\03_scene\\day16\\day16要求.txt";
    public static final String File_To = "./";
    public static void main(String[] args) {
        FileTransfer fileTransfer = new FileTransfer();

//        一次粗去一个字节
        long begin01 = System.currentTimeMillis();
        fileTransfer.copyByAnByte(File_PATH,File_To);
        long end01 = System.currentTimeMillis() - begin01;
        System.out.println("一次粗去一个字节 = " +  end01 );
//        缓冲粗去一个字节
        long begin02 = System.currentTimeMillis();
        fileTransfer.copyByAnByteReffered(File_PATH,File_To);
        long end02 = System.currentTimeMillis() - begin02;
        System.out.println("缓冲粗去一个字节 = " +  end02 );

        // 一次读取1024字节
        long begin03 = System.currentTimeMillis();
        fileTransfer.copyByByte(File_PATH,File_To);
        long end03 = System.currentTimeMillis() - begin03;
        System.out.println("一次读取1024字节 = " +  end03 );

        //缓冲读取1024 字节
        long begin04 = System.currentTimeMillis();
        fileTransfer.copyByByteReffered(File_PATH,File_To);
        long end04 = System.currentTimeMillis() - begin04;
        System.out.println("缓冲读取1024 字节 = " +  end04);
    }



}
