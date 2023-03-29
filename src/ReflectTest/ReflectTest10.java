package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 用反射机制调用构造方法
 */
public class ReflectTest10 {
    public static void main(String[] args) {
        //不用反射调用构造方法
//        Student s1=new Student();
//        Student s2=new Student(20183132);
//        Student s3=new Student(20183132,"三号憨憨");
//        Student s4=new Student(20183135,"四号憨憨",'男');
//        Student s5=new Student(20183136,"五号憨憨",'男',19);

        //用反射机制调用构造方法
        try {
            Class studentClass=Class.forName("ReflectTest.Student");
            //调用无参构造函数
            //Object o=studentClass.newInstance();

            //获取无参构造方法
            Constructor cons1=studentClass.getDeclaredConstructor();//无参构造
            //调用有参构造函数
            //获取有参构造方法(方法参数里写构造参数类型的.class)
            Constructor cons2=studentClass.getDeclaredConstructor(int.class);//一个参数构造方法
            Constructor cons3=studentClass.getDeclaredConstructor(int.class,String.class);//两个参数构造方法
            Constructor cons4=studentClass.getDeclaredConstructor(int.class,String.class,char.class,int.class);
            //调用构造参数创建对象
            Object o1=cons1.newInstance();
            Object o2=cons2.newInstance(2018313);
            Object o3=cons3.newInstance(20183132,"憨憨");
            Object o4=cons4.newInstance(201873132,"大憨憨",'男',19);
            //输出
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o3);
            System.out.println(o4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
