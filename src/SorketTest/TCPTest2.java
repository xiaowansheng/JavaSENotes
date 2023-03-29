package SorketTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * 实现TCP网络编程
 *      例子2：客户端发送文件给服务器，服务器保存在本地并发送反馈信息
 */
public class TCPTest2 {

    //服务器
    @Test
    public void server(){
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream inputStream=null;
        FileOutputStream fileOutputStream=null;
        OutputStream out=null;
        try {
            serverSocket=new ServerSocket(8870);
            socket=serverSocket.accept();
            inputStream = socket.getInputStream();
            fileOutputStream=new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\Notes\\src\\SorketTest\\天空(接收).jpg");
            byte[] b=new byte[512];
            int readCount=0;
            while ((readCount=inputStream.read(b))!=-1){
                fileOutputStream.write(b,0,readCount);
            }
            System.out.println("文件已接收。");
            //反馈接受信息
            out=socket.getOutputStream();
            out.write("来自服务端的消息：图片已经收到，很好看。".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
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
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //客户端
    @Test
    public void client(){
        Socket socket=null;
        OutputStream out=null;
        FileInputStream f=null;
        InputStream inputStream=null;
        ByteArrayOutputStream byteArrayOutputStream=null;
        try {
            //(1)
            socket=new Socket(InetAddress.getLoopbackAddress(),8870);
            //(2)
            out=socket.getOutputStream();
            //(3)
            f=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\Notes\\src\\SorketTest\\天空.jpg");
            //(4)
            int readCount=0;
            byte[] b=new byte[512];
            while ((readCount=f.read(b))!=-1){
                out.write(b,0,readCount);
            }
            //告诉服务器传输完成中断连接
            socket.shutdownOutput();
            //
            System.out.println("文件传输完成。");

            //将收到的信息打印在控制台
            byteArrayOutputStream=new ByteArrayOutputStream();
            inputStream=socket.getInputStream();
            while((readCount=inputStream.read(b))!=-1){
                byteArrayOutputStream.write(b,0,readCount);
            }
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(f!=null){
                try {
                    f.close();
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
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteArrayOutputStream!=null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
