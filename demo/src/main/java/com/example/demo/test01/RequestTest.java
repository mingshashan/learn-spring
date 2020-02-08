package com.example.demo.test01;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * RequestTest
 *
 * @author jasonxu
 */
public class RequestTest {
    public static void main(String[] args) {


        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<Object>> result = asyncRestTemplate.getForEntity("http://www.baidu.com", Object.class);

        result.addCallback(new SuccessCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("success");
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("failure");
            }
        });
        System.out.println("over");

    }
}
