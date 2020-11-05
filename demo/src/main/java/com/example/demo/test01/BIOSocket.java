package com.example.demo.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOSocket {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(9090);
            System.out.println("step1: new ServerSocket(9090)");

            while (true) {
                Socket client = socket.accept();  //阻塞1
                System.out.println("step2: client: \t" + client.getPort());
                new Thread(() -> {
                    InputStream in = null;

                    try {
                        in = client.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

                        while (true) {
                            String dataLine = bufferedReader.readLine(); //阻塞2
                            if (null != dataLine) {
                                System.out.println("step3: client info: \t [" + dataLine + "]");
                            } else {
                                client.close();
                                break;
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
