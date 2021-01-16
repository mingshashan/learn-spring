package com.mingshashan.learn.netty.rpc.common;

/**
 * RpcResponse
 *
 * @author xufj
 */
public class RpcResponse {

    private String requestId;
    private String error;
    private Object result;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RpcResponse{");
        sb.append("requestId='").append(requestId).append('\'');
        sb.append(", error='").append(error).append('\'');
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
