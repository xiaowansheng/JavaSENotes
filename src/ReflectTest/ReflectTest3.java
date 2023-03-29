package ReflectTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 验证反射机制灵活性：
 *          java代码写一遍，在不改变java源代码的基础上，可以做到不同对象的实例化。
 *          非常灵活。（符合OCP开闭原则：对扩展开放，对修改关闭。）
 *
 * 后期学习的是高级框架，工作中也是使用高级框架。
 * 包括：SSH,SSM
 *      Spring,SpringMVC,MyBatis
 *      Spring,Struts,Hibernate
 *      ......
 *      这些框架的底层原理：都采用反射机制。
 *      所以反射机制非常重要，学会反射机制有利于理解剖析框架底层源代码。
 * */
public class ReflectTest3 {
    public static void main(String[] args) {
        //这种方式代码写死了，只能创建User类型的对象
        //User u=new User();
        //System.out.println(u);

        FileReader f=null;
        try {
            //IO流读取文件
            f=new FileReader("D:\\java\\IDEACommunity-Project\\javaSE\\HelloWorld\\src\\ReflectTest\\classinfo.properties");
            //创建属性类对象Map
            Properties p=new Properties();//k-v都是String
            //数据加载到Map中
            p.load(f);
            //用key获取value
            String s=p.getProperty("className");
            System.out.println(s);
            //获取.class文件
            Class c=Class.forName(s);
            //通过反射机制实例化对象
            Object o=c.newInstance();
            System.out.println(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            if(f!=null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
