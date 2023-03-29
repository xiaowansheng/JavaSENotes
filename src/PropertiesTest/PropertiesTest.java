package PropertiesTest;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        //Properties
        //继承自Hshtable
        //是线程安全的
        //Properties的key和value都是String类型，只能存储String类型数据
        //Properties被称为属性类对象
        //需要掌握两个方法，一个存，一个取
        //setProperty(String key,String value),存
        //getProperty(String key),取

        Properties p = new Properties();
        p.setProperty("1234", "ldq");
        p.setProperty("12345", "abc");
        p.setProperty("123456", "abcd");
        p.setProperty("1234567", "abcde");
        p.setProperty("12345678", "abcdef");
        System.out.println(p.size());
        String a = p.getProperty("12345");
        String b = p.getProperty("123456");
        String c = p.getProperty("1234567");
        String d = p.getProperty("12345678");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}