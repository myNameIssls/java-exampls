package cn.tyrone.javase.socket.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    final static String ADDRESS = "127.0.0.1";
    final static int PORT = 8765;

    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket( ADDRESS, PORT );
            in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            out = new PrintWriter( socket.getOutputStream(), true );

            out.println("接收到客户端的数据");
            String response = in.readLine();

            System.out.println("Client: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null ) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) out.close();

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
