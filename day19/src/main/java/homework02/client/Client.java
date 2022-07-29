package homework02.client;

import homework02.utils.Message;
import homework02.utils.Utils;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * socket.getInputStream() 会堵塞到接受到内容
 * 获取输出流不堵塞
 * 一次连接中的输出流、输入流关闭，socket 关闭
 * 一次连接中的输出流、输入流，都是同一个，重复获取，会出错
 * @since  2022-07
 */
public class Client {
    private Socket socket;
    //    private InputStream is;
//    private OutputStream os;
    private ObjectInputStream bis;
    private ObjectOutputStream bos;
    private Scanner scanner;
//    private List<String> picList;

    public Client() throws IOException {
        initCli();
    }

    public void initCli() throws IOException {
//        socket = new Socket(InetAddress.getLocalHost(), Utils.PORT);
        socket = new Socket(Utils.SERVER_IP, Utils.PORT);
        bis = new ObjectInputStream(socket.getInputStream());
        bos = new ObjectOutputStream(socket.getOutputStream());
        scanner = new Scanner(System.in);
    }

    public void  receiveWelcomeMsg() throws IOException, ClassNotFoundException {
        Message welcomeMsg = (Message) bis.readObject();
        System.out.println("[server:]" + welcomeMsg.getMsg());
    }
    public void homePage() throws IOException, ClassNotFoundException {
        receiveWelcomeMsg();

        boolean close = false;
        int choose;

        while ( !close) {
            System.out.println("===========welcome to the SGU picture server=======");
            System.out.println("\t 1、scan all pictures");
            System.out.println("\t 2、upload picture");
            System.out.println("\t 3、download picture");
            System.out.println("\t 4、exit");

            try {
                System.out.print("input your choose :\t");
                choose = scanner.nextInt();
                switch (choose) {
                    case Utils.PICTURES:
                        scanPictures();
                        break;
                    case Utils.UPLOAD:
                        String picName = getPicName(Utils.LOCAL_SAVE_PATH);
                        if (picName != null) {
                            uploadPic(Utils.LOCAL_SAVE_PATH , picName);
                        }
                        break;
                    case Utils.DOWNLOAD:
                        downPic();
                        break;
                    case Utils.EXIT:
                        exit();
                        close = true;
                        break;
                    default:
                        System.out.println("please input correctly !!");
                        continue;

                }
            }
//            catch () {
//                System.out.println("somthing wrong happen !! please do it again !!");
////                System.out.println(e.getCause());
////                System.out.println(e.getMessage());
//                continue;
//            }
            catch (InterruptedException e) {
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }

    }

    private void downPic() throws IOException, ClassNotFoundException {
        List<String> pictures = getPictures();

        for (int i = 0; i < pictures.size(); i++) {
            System.out.println(i + 1 + "、\t" + pictures.get(i));
        }

        System.out.print("input the picture you want to download:\t");
        int no = scanner.nextInt();

        if (no < 1 || no > pictures.size()) {
            System.out.println("there is not this picName");
            return;
        }
        System.out.println("pictures.get(no - 1)================================ = " + pictures.get(no - 1));
        File savePath = Utils.repeatedFiles(Utils.LOCAL_SAVE_PATH, pictures.get(no - 1));
        try (
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(savePath))
        ) {
            Message sendMsg = new Message();
            sendMsg.setName(pictures.get(no - 1));
            sendMsg.setCode(3);
            System.out.println(sendMsg.getCode());
            bos.writeObject(sendMsg);

            Message receiveMsg = (Message) bis.readObject();
//            System.out.println("==================================================" + receiveMsg);
            if (receiveMsg.getCode() == Utils.SUCCEED){
                byte[] bytes = receiveMsg.getBytes();
                bufferedOutputStream.write(bytes, 0, receiveMsg.getLen());
            }else {
                System.out.println(receiveMsg.getMsg());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 展示本地 图库，
     * 选择要上传的图片
     * @return
     */
    public String getPicName(String picPath) {
        List<String> picList = Utils.getPicList(picPath);
        for (int i = 0; i < picList.size(); i++) {
            System.out.println(i + 1 + " \t" + picList.get(i));
        }

        System.out.print("please input the picture num that you want to upload :");
        int picNo = scanner.nextInt();
        if (picNo > picList.size() || picNo < 1) {
            System.out.println("there is not this picName");
            return null;
        }
        return picList.get(picNo - 1);
    }

    private void uploadPic(String dir ,String picName) {
        File file = new File(dir + picName);

        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            Message message = new Message();
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                message.setLen(message.getLen() + len);
                byteArrayOutputStream.write(bytes, 0, len);
            }

            message.setBytes(byteArrayOutputStream.toByteArray());
            message.setCode(Utils.UPLOAD);
            message.setName(picName);

            bos.writeObject(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("upload succeed !!");
    }


    public List<String> getPictures() throws IOException, ClassNotFoundException {
        System.out.println("----------scan all pictures-------");
        Message sendMsg = new Message();
        sendMsg.setCode(Utils.PICTURES);
        bos.writeObject(sendMsg);

        Message message = (Message) bis.readObject();

        return message.getPicName();
    }

    public void scanPictures() throws IOException, ClassNotFoundException {
        List<String> picList = getPictures();
        if (picList == null) {
            System.out.println("there is not picture in the server!");
        }

        for (int i = 0; i < picList.size(); i++) {
            System.out.println(i + 1 + "、\t" + picList.get(i));
        }
        System.out.println("there are " + picList.size() + "pictures");
    }

    public void exit() throws IOException, InterruptedException {
        Message message = new Message();
        message.setCode(Utils.EXIT);
        bos.writeObject(message);

        //休眠一定时间，服务器先关闭socket
        Thread.sleep(new Random().nextInt(5000) + 1000);
        Utils.closeStream(bis, bos);
        Utils.closeSocket(socket);
    }
}
