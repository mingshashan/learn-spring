package com.mingshashan.learn.alibaba.client.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.ListView;

import java.util.Properties;

/**
 * Tets
 *
 * @author jasonxu
 */
public class Tets {
    public static void main(String[] args) throws NacosException {

        Properties properties = new Properties();
        // Nacos 的服务中心的地址
        properties.put(PropertyKeyConst.SERVER_ADDR, "192.168.16.38:8848");
        properties.put(PropertyKeyConst.NAMESPACE, "778537eb-c3f2-421b-95e6-50ca525cdfc2");
        NamingService nameService = NacosFactory.createNamingService(properties);
        ListView<String> listView = nameService.getServicesOfServer(0, 100);
        nameService.getAllInstances("api-service");
        System.out.println(listView.getCount());


    }
}
