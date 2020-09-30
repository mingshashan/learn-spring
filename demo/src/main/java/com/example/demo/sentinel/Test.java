package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * Test
 *
 * @author jasonxu
 */
public class Test {

    @SentinelResource("HelloWorld")
    public void helloWorld() {
        // 资源中的逻辑
        System.out.println("hello world");
    }
}
