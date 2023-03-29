package ReflectTest;

import java.util.ArrayList;
import java.util.Date;

/**
 * java.lang.reflect.*
 *
 * */
public class ReflectTest {
    public static void main(String[] args) {
        //获取方式（1）
        Class c1=null;
        Class c2=null;
        try {
            c1=Class.forName("java.lang.String");//c1代表String.class文件，或者说代表String类型
            c2=Class.forName("java.lang.Integer");//c2代表Integer.class文件，或者说代表Integer类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //java中任何一个对象都有一个方法：getClass();

        String s1=new String("ABC");
        //获取方式（2）
        Class cs1=s1.getClass();//cs1代表String.class字节码文件，cs1代表String类型
        System.out.println(c1==cs1);//true(判断内存地址)

        //获取方式（3）
        //java语言中的任何一种类型，包括基本数据类型，它都有.class属性
        Class a=String.class;//a代表String类型
        Class b=Integer.class;//b代表Integer类型
        Class c=Date.class;//c代表Date类型
        Class d=int.class;//d代表int类型
        Class e= ArrayList.class;//e代表ArrayList类型

        System.out.println(cs1==a);//true
    }
}
