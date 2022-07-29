package homework02.server;

import homework02.utils.Utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(Utils.PORT);
    }

    public void service(){
        boolean close = false;
        Socket accept = null;

        while ( !close){
            try {
                accept = serverSocket.accept();
                System.out.println(accept.getInetAddress() + "connection succeed");

                ServerTask serverTask = new ServerTask(accept);
                new Thread(serverTask).start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
