package com.mingshashan.learn.netty.rpc.api;

/**
 * IRpcService
 *
 * @author jasonxu
 */
public interface IRpcService {

    int add(int a, int b);
    int sub(int a, int b);
    int multiply(int a, int b);
    int div(int a, int b);
}
