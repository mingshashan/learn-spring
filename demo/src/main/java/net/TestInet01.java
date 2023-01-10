package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mingshashan
 */
public class TestInet01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        printInetAddress(localHost);

        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        printInetAddress(baidu);

        InetAddress google = InetAddress.getByName("www.google.com");
        printInetAddress(google);
    }

    static void printInetAddress(InetAddress inetAddress) {
        System.out.println("InetAddress: " + inetAddress);
        System.out.println("主机名: " + inetAddress.getHostName());
        System.out.println("IP地址: " +
                inetAddress.getHostAddress());
    }
}
