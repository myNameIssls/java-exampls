package cn.tyrone.javase.socket.helloworld;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PORT = 8765;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket( PORT );
            System.out.println("Server start................");
            Socket socket = null;
//            new Thread( new ServerHandler( socket ) ).start();

            HandlerExecuterPool handlerExecuterPool = new HandlerExecuterPool( 50, 1000 );

            while (true) {
                socket = serverSocket.accept();
                handlerExecuterPool.execute( new ServerHandler( socket ) );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
