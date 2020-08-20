package com.mingshashan.learn.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BioClient {

    private final static int PORT = 9091;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", PORT);

            while (true) {
                sendMsg(socket);
            }


//            receiveMsg(socket);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void receiveMsg(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        while (-1 != length) {
            String msg = new String(buffer, 0, length);
            System.out.println(String.format("接收到服务端的消息： %s", msg));
        }
    }

    private static void sendMsg(Socket socket) throws IOException {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = socket.getOutputStream();
        String uuid = UUID.randomUUID().toString();
        outputStream.write(uuid.getBytes());
        System.out.println(String.format("客户端发送的消息： %s", uuid));
    }
}
