package com.mingshashan.learn.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BioServer {

    private final static int PORT = 9091;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                doService(socket);
            }


//            doSend(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doService(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        if (-1 != length) {
            String msg = new String(buffer, 0, length);
            System.out.println(String.format("接收到客户端的消息： %s", msg));
        }
    }

    private static void doSend(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        String date = new Date().toString();
        String msg = "server send msg " + date;
        outputStream.write(msg.getBytes());
    }
}
