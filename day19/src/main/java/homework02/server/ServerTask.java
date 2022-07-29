package homework02.server;

import homework02.utils.Message;
import homework02.utils.Utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ServerTask implements Runnable {
    private ServerSocket serverSocket;
    Socket accept ;

    public ServerTask(Socket socket) throws IOException {
        accept = socket;
    }


    @Override
    public void run() {
        ObjectOutputStream bos;
        ObjectInputStream bis;

        try {
            bos = new ObjectOutputStream(accept.getOutputStream());

            Message message = new Message();
            String welcomeMsg = "connect to the server succeed !\n server ip is " + accept.getLocalAddress() + "\n client ip is " + accept.getInetAddress();
            message.setMsg(welcomeMsg);
            bos.writeObject(message);

            bis = new ObjectInputStream(accept.getInputStream());
            boolean close =false;
            while ( !close){
                Message receiptMsg = (Message) bis.readObject();
                int choose = receiptMsg.getCode();
                System.out.println(choose);

                switch (choose) {
                    case Utils.PICTURES:
                        System.out.println(Thread.currentThread().getName() + "\t:" + accept.getInetAddress() + ":\twant to get picture list\t" + new Date());
                        returnPictures(bos);
                        break;
                    case Utils.UPLOAD:
                        System.out.println(Thread.currentThread().getName() + "\t:" +accept.getInetAddress() + ":\t upload picture\t" + new Date());
                        returnUpload(bos,receiptMsg);
                        break;
                    case Utils.DOWNLOAD:
                        System.out.println(Thread.currentThread().getName() + "\t:" +accept.getInetAddress() + ":\t download picture\t" + new Date());
                        returnDownload(bos,receiptMsg);
                        break;
                    case Utils.EXIT:
                        System.out.println(Thread.currentThread().getName() + "\t:" +accept.getInetAddress() + ":\t exit\t" + new Date());
                        close = true;
                        returnExit(bos, bis, accept);
                        break;
//                    default:
//                        break;

                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void returnPictures(ObjectOutputStream bos) throws IOException {
        List<String> picList = Utils.getPicList(Utils.SERVER_PIC_PATH);

        Message message = new Message();
        message.setPicName(picList);
        bos.writeObject(message);
    }

    public void returnUpload(ObjectOutputStream bos,Message message){
        byte[] bytes = message.getBytes();
        String name = message.getName();

        File file = Utils.repeatedFiles(Utils.SERVER_SAVE_PATH,name);

        try (
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        ){
            bufferedOutputStream.write(bytes,0,message.getLen());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void returnDownload(ObjectOutputStream bos, Message receiptMsg) throws IOException {
        String name = receiptMsg.getName();

        File file = new File(Utils.SERVER_PIC_PATH + name);
        Message message = new Message();
        if ( !file.isFile()) {
            message.setCode(Utils.FAILED);
            message.setMsg("不存在输入的照片名！！！");
            bos.writeObject(message);
        }else {
            try(
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
            ) {
                int len = -1;
                byte[] bytes = new byte[1024];

                while ( (len = bufferedInputStream.read(bytes)) != -1){
                    byteArrayOutputStream.write(bytes,0,len);
                    message.setLen(message.getLen() + len);
                }
                byte[] byteArr = byteArrayOutputStream.toByteArray();

                message.setCode(Utils.SUCCEED);
                message.setBytes(byteArr);

//                System.out.println("==================================================" + message);
                bos.writeObject(message);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void returnExit(ObjectOutputStream bos,ObjectInputStream bis,Socket socket){
        Utils.closeStream(bis,bos);
        Utils.closeSocket(socket);
    }
}
