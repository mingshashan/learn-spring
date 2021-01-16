package com.mingshashan.learn.netty.rpc.common;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ServerHandler
 *
 * @author xufj
 */
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<RpcRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest msg) throws Exception {

        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setRequestId(msg.getRequestId());
        try {
            Object ret = handler(msg);
            rpcResponse.setResult(ret);
        } catch (Throwable throwable) {
            rpcResponse.setError(throwable.getMessage());
            throwable.printStackTrace();
        }
        ctx.writeAndFlush(rpcResponse);
    }

    private Object handler(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(request.getClassName());

        Method method = clazz.getMethod(request.getMethodName(), request.getParameterTypes());
        Object[] parameters = request.getParameters();

        Object obj = ServiceFactory.INSTANCE.getServiceObj(clazz);
        Object ret = method.invoke(obj, parameters);

        return ret;
        //
    }


}
