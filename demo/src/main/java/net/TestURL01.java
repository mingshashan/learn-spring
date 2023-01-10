package net;

import java.net.URL;

public class TestURL01 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com:80/s?wd=Java#bd") ;
        printURL(url);
    }
    private static void printURL (URL url){
        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名：" + url.getHost());
        System.out.println("端口：" + url.getPort());
        System.out.println("路径：" + url.getPath());
        System.out.println("参数：" + url.getQuery());
        System.out.println("文件：" + url.getFile());
        System.out.println("锚点：" + url.getRef());
    }
}