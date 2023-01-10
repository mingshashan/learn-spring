package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TestHttp01 {
    public static void main(String[] args) throws Exception {
        // 访问 网址 内容
        URL url = new URL("https://www.jd.com");
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
        printHttp(httpUrlConnection);

        // 请求 服务 接口
        URL api = new URL("http://localhost:8082/info/99");
        HttpURLConnection apiConnection = (HttpURLConnection) api.openConnection();
        apiConnection.setRequestMethod("GET");
        apiConnection.setConnectTimeout(3000);
        printHttp(apiConnection);
    }

    private static void printHttp (HttpURLConnection httpUrlConnection) throws Exception{
        try (InputStream inputStream = httpUrlConnection.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,
                    StandardCharsets.UTF_8));
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}