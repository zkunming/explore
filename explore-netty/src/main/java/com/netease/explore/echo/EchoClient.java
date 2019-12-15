/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.netease.explore.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Keeps sending random data to the specified address.
 */
public final class EchoClient {

  static final String HOST = System.getProperty("host", "127.0.0.1");
  static final int PORT = Integer.parseInt(System.getProperty("port", "8009"));

  public static void main(String[] args) throws Exception {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(group)
          .channel(NioSocketChannel.class)
          .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              ChannelPipeline p = ch.pipeline();
              p.addLast(new EchoClientHandler());
            }
          });

      // Make the connection attempt.
      ChannelFuture f = bootstrap.connect(HOST, PORT).sync();

      // Wait until the connection is closed.
      f.channel().closeFuture().sync();
    } finally {
      System.out.println("[EchoClient] Hello world!");
      group.shutdownGracefully();
    }
  }
}
class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


  public static final EchoClientHandler newOne() {
    EchoClientHandler clientHandler = new EchoClientHandler();
    return clientHandler;
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
    Map<String, ChannelHandler> stringChannelHandlerMap = ctx.pipeline().toMap();
    System.out.println(stringChannelHandlerMap);
    String response = byteBuf.toString(Charset.defaultCharset());
    System.out.println("收到服务端的相应：" + response);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    ctx.channel().writeAndFlush("Hello");
    ByteBuf buffer = ctx.alloc().buffer();
    buffer.writeBytes("I am client!".getBytes());
    ctx.writeAndFlush(buffer);
  }
}
