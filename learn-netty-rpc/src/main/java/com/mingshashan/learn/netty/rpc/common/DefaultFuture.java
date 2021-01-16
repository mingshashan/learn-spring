package com.mingshashan.learn.netty.rpc.common;

/**
 * DefaultFuture
 *
 * @author xufj
 */
public class DefaultFuture {

    private RpcResponse rpcResponse;
    private volatile boolean isSucceed = false;
    private final Object lock = new Object();

    public void setResponse(RpcResponse response) {
        if (isSucceed) {
            return;
        }

        synchronized (lock) {
            this.rpcResponse = response;
            this.isSucceed = true;
            lock.notify();
        }
    }

    /**
     *
     * @param timeout 超时时间，单位为秒
     * @return
     */
    public RpcResponse getRpcResponse(int timeout) {
        synchronized (lock) {
            while (!isSucceed) {
                try {
                    lock.wait(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.rpcResponse;
        }
    }
}
