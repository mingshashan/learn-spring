package com.mingshashan.learn.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.Date;

/**
 * EchoServerHandler
 *
 * @author jasonxu
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        String inMsg = in.toString(CharsetUtil.UTF_8);
        System.out.println("服务端接收到消息：" + inMsg);

        ByteBuf out = Unpooled.copiedBuffer(new Date().toString() + "\n", CharsetUtil.UTF_8);
        // 将接收到的消息写给发送者，而不冲刷出栈消息
        ctx.write(out);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 将消息冲刷到客户端，并且关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
//        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        // 打印异常堆栈跟踪
        cause.printStackTrace();;
        // 关闭该Channel
        ctx.close();
//        super.exceptionCaught(ctx, cause);
    }
}
