package com.yang.server.discard;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

public class DiscardServerHandler extends SimpleChannelInboundHandler<SocketChannel> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SocketChannel msg) throws Exception {
        System.out.println(this + "1231231321");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(this + "6666666");
    }
}
