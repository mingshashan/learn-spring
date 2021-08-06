package com.mingshashan.learn.netty.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

                    Message message = (Message) inputStream.readObject();
                    System.out.printf("server receive message [%s].\n", message.getContent());

                    message.setContent("success, lol");
                    outputStream.writeObject(message);
                    outputStream.flush();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HelloServer helloServer = new HelloServer();
        helloServer.start(16061);
    }
}
