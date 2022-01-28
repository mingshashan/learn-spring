package com.mingshashan.learn.mq.rocket.learn01;

import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

import java.util.HashMap;

public class ConsumerRPCHook implements RPCHook {

    static HashMap<String, String> extFields = new HashMap<>();

    static {
        extFields.put("whoami", "consumer");
    }

    @Override
    public void doBeforeRequest(String remoteAddr, RemotingCommand request) {

        System.out.printf("before consume message to broker-[%s]\n", remoteAddr);
    }

    @Override
    public void doAfterResponse(String remoteAddr, RemotingCommand request, RemotingCommand response) {
        System.out.println(request.getExtFields());

        System.out.printf("after consume message to broker-[%s]\n", remoteAddr);
    }
}
