package com.mingshashan.learn;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ClientApp1 {
    public static void main(String[] args) throws NacosException, IOException {
        String serverAddr = "localhost";
        String dataId = "example";
        String group = "DEFAULT_GROUP";

        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(configService.getServerStatus());
        System.out.printf("first receive: [%s]\n", content);

        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.printf("%s receive: [%s]\n", new Date().toString(), configInfo.toString());
            }
        });

        int n = System.in.read();
    }
}
