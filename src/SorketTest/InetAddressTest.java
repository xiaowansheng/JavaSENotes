package SorketTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 *  在java类中使用InetAddress类表示IP地址。
 *  IP分类：Ipv4和Ipv6；万维网和局域网
 *
 *  本机回路地址：127.0.0.1，对应LocalHost
 *
 *  （看文档）
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //构造IP类对象
            InetAddress it=InetAddress.getByName("192.168.10.14");
            //输出IP
            System.out.println(it);

            //也可传入域名来解析
            InetAddress it2=InetAddress.getByName("www.baidu.com");
            //输出域名和IP
            System.out.println(it2);
            //获取域名
            System.out.println(it2.getHostName());
            //获取地址
            System.out.println(it2.getHostAddress());

            //获取本机IP
            InetAddress it3=InetAddress.getLocalHost();
            System.out.println(it3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
