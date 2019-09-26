package com.netease.explore.echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.nio.charset.Charset;

public class CustomerHandle extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    String preHandleResult = msg.toString();
    System.out.println("CustomerHandle 接收到："+preHandleResult);

    ctx.writeAndFlush(
        Unpooled.copiedBuffer("CustomerHandle 接收到：" + preHandleResult, Charset.defaultCharset()));
 }

}
