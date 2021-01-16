package com.mingshashan.learn.netty.rpc.common;

import java.util.Arrays;

/**
 * RpcRequest
 *
 * @author xufj
 */
public class RpcRequest {
    private String requestId;
    private String className;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RpcRequest{");
        sb.append("requestId='").append(requestId).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", parameterTypes=").append(parameterTypes == null ? "null" : Arrays.asList(parameterTypes).toString());
        sb.append(", parameters=").append(parameters == null ? "null" : Arrays.asList(parameters).toString());
        sb.append('}');
        return sb.toString();
    }
}
