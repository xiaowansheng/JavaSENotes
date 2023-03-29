package SorketTest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * 实现TCP网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据输出在控制台
 * (先启动服务端)
 */
public class TCPTest {
    //客户端
    @Test
    public void client(){
        Socket socket=null;
        OutputStream out=null;
        try {
            InetAddress it=InetAddress.getByName("127.0.0.1");
            //创建Socket对象，指明服务端的ip和端口号
            socket=new Socket(it,8868);
            //获取输出流，用于输出对象
            out = socket.getOutputStream();
            //写出数据
            out.write("你好，我是客户端".getBytes());
            out.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //资源关闭
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server(){
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream inputStream=null;
        ByteArrayOutputStream out=null;
        try {
            //创建服务器端的ServerSocket，指明自己的端口号
            serverSocket=new ServerSocket(8868);
            //调用accept()，表示接受来自客户端的Socket
            //侦听要连接到此套接字并接受它（来自文档）。
            socket=serverSocket.accept();

            //打印连接的用户
            System.out.println("收到来自用户：["+socket.getInetAddress().getHostName()+"]的消息。");

            //获取一个输入流
            inputStream = socket.getInputStream();

            //读取输入流的数据

            //不建议这样写，可能输出有乱码
/*            byte[] bytes=new byte[20];
            int readCount=0;
            if((readCount= inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,readCount));
            }*/

            //用ByteArrayOutputStream()可以自动扩容
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[5];
            int readCount=0;
            while((readCount= inputStream.read(buffer))!=-1){
                out.write(buffer,0,readCount);
            }
            System.out.println(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
