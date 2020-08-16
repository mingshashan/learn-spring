package com.mingshashan.learn.netty.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BioServer
 *
 * @author jasonxu
 */
public class BioServer {

    public static void main(String[] args) {
        new BioServer(9010).start();
    }

    private int port;

    public BioServer(int port) {
        this.port = port;
    }

    public void start() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(this.port);

            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

//            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            String msg = reader.readLine();
            if (null != msg) {
                System.out.println("收到消息：" + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
