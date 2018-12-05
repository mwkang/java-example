package com.minwoo.kang.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelSample {

  public static void main(String[] args) throws IOException {
    try (ServerSocketChannel ssc = ServerSocketChannel.open()) {
      ssc.bind(new InetSocketAddress(7000));
      ssc.configureBlocking(false);

//    ▶ curl http://localhost:7000/
//    curl: (56) Recv failure: Connection reset by peer
//    Hello World%
      while (true) {
        try (SocketChannel sc = ssc.accept()) {
          if (sc != null) {
            sc.write(ByteBuffer.wrap("Hello World".getBytes()));
          }
        }
      }
    }
  }
}
