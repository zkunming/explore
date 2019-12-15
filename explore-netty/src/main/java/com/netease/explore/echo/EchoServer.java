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

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Discards any incoming data.
 */
public final class EchoServer {

  private static String HANDLE_NAME = "EchoHandle";
  private static String CUSTOMER_HANDLE = "CustomerHandle";

  public static void main(String[] args) throws Exception {

    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup(10);
    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .localAddress(new InetSocketAddress(8009))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel socketChannel) {
              ChannelPipeline pipeline = socketChannel.pipeline();
              pipeline.addLast(HANDLE_NAME, new EchoServerHandler());
            }
          });

      // Bind and start to accept incoming connections.
      ChannelFuture f = bootstrap.bind().sync();

      f.channel().closeFuture().sync();
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }


  }
}
class EchoServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext handlerContext, Object msg) throws Exception {
    ByteBuf byteBuf = (ByteBuf) msg;


    System.out.println("【服务端】收到请求："+byteBuf.toString(Charset.defaultCharset()));

    if (true) {
      throw new IllegalArgumentException("我是捣乱的...........");
    }
    String response = "我是服务端！";
    StringBuilder stringBuilder = new StringBuilder();
    int size = 1;
    for (int i = 0; i < size; i++) {
      stringBuilder.append(response);
    }
    ByteBuf responseB = Unpooled.copiedBuffer(stringBuilder.toString(), Charset.defaultCharset());
    handlerContext.write(responseB);
    handlerContext.fireChannelRead(response);

  }
  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelReadComplete.....");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    //关闭这个连接
    ctx.close();
  }
}

class CustomerHandle extends ChannelInboundHandlerAdapter {

@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    String preHandleResult = msg.toString();
    System.out.println("CustomerHandle 接收到："+preHandleResult);

    ctx.writeAndFlush(
    Unpooled.copiedBuffer("CustomerHandle 接收到：" + preHandleResult, Charset.defaultCharset()));
    }

    }

