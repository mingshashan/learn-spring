package com.mingshashan.learn.netty.learn02;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpMethod;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class HttpClient02 {

    public static void main(String[] args) {
        HttpClient.create().baseUrl("http://localhost:18081")
                .request(HttpMethod.GET)
                .send(s -> Unpooled.wrappedBuffer("Hello World".getBytes(StandardCharsets.UTF_8)))
                .responseContent()
                .subscribe(byteBuf -> System.out.printf("Receive content = [%s]", byteBuf.toString(StandardCharsets.UTF_8)));
    }

}
