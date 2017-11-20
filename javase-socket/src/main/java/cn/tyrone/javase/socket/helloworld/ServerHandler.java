package cn.tyrone.javase.socket.helloworld;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {

            in = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
            out = new PrintWriter( this.socket.getOutputStream(), true);

            String body = null;

            while (true) {
                body = in.readLine();
                if (body == null) break;
                System.out.println("Server: " + body);
                out.println("服务器端发送的响应数据");
            }

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
