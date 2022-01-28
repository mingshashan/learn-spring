package com.mingshashan.learn.mq.rocket.learn01;

import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

import java.util.HashMap;

public class ProducerRPCHook implements RPCHook {
    static HashMap<String, String> extFields = new HashMap<>();

    static {
        extFields.put("whoami", "producer");
    }

    @Override
    public void doBeforeRequest(String remoteAddr, RemotingCommand request) {

        request.setExtFields(extFields);
        System.out.printf("before send message to broker-[%s]\n", remoteAddr);
    }

    @Override
    public void doAfterResponse(String remoteAddr, RemotingCommand request, RemotingCommand response) {
        System.out.println(response.getExtFields());
        System.out.printf("after send message to broker-[%s]\n", remoteAddr);
    }
}
