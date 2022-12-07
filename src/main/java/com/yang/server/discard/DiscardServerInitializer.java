package com.yang.server.discard;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

public class DiscardServerInitializer extends ChannelInitializer<SocketChannel> {
    SslContext sslCtx;
    public DiscardServerInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        if (sslCtx != null) {
            p.addLast(sslCtx.newHandler(ch.alloc()));
        }
        p.addLast(new DiscardServerHandler());

    }
}
