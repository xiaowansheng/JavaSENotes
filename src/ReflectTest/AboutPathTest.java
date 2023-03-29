package ReflectTest;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * 获取路径的方法：
 *          （1）
 *          文件必须放在类路径下
 *          Thread.currentThread().getContextClassLoader().getResource("完整的相对路径").getPath();
 *          （2）
 *          资源绑定器
 *          文件必须放在类路径下
 *          写路径的时候文件后缀不能加
 *          只能绑定xxx.properties文件
 *          获取属性配置文件中的内容
 *          ResourceBundle r=ResourceBundle.getBundle("完整相对路劲");
 * */
public class AboutPathTest {
    public static void main(String[] args) {
        //(1)
        //D:/java/IDEACommunity-Project/javaSE/out/production/HelloWorld/
        String s2=Thread.currentThread()
                .getContextClassLoader().getResource("").getPath();
        //D:/java/IDEACommunity-Project/javaSE/out/production/HelloWorld/ReflectTest/AboutPathTest.class
        String s=Thread.currentThread().getContextClassLoader()
                .getResource("ReflectTest/AboutPathTest.class").getPath();
        File f=new File(s);
        System.out.println(f.isFile());
        System.out.println(s2);
        System.out.println(s);

        //(2)
        ResourceBundle r=ResourceBundle.getBundle("ReflectTest/classinfo");
        System.out.println(r);
        String st=r.getString("className");
        System.out.println(st);
    }
}
