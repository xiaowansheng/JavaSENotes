package SorketTest;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 *
 * UDP协议的网络编程
 */
public class UDPTest {
    //发送端
    @Test
    public void send() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        InetAddress it=InetAddress.getByName("127.0.0.1");
        byte[] b="你好，我是发送端.".getBytes();
        DatagramPacket packet=new DatagramPacket(b,0,b.length,it,8890);
        socket.send(packet);
    }

    //接收端
    @Test
    public void receive() throws IOException {
        DatagramSocket socket=new DatagramSocket(8890);
        byte[] b=new byte[50];
        DatagramPacket packet=new DatagramPacket(b,0,b.length);
        socket.receive(packet);
        System.out.println("来自发送端的消息："+new String(packet.getData()));

        //关闭
        socket.close();
    }
}

