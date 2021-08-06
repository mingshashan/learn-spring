package com.mingshashan.learn.netty.bio;

import javax.crypto.MacSpi;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloClient {

    public Message sendMsg(Message msg) {

        try (Socket socket = new Socket("127.0.0.1", 16061)) {

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(msg);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            return (Message) inputStream.readObject();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        HelloClient helloClient = new HelloClient();
        Message send = new Message();
        send.setContent("1");
        Message receive = helloClient.sendMsg(send);
        System.out.printf("client receive message = [%s]\n", receive.getContent());

    }
}
