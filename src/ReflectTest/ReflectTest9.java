package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 反编译一个类的Constructor方法（构造方法）
 *
 */
public class ReflectTest9 {
    public static void main(String[] args) {

        try {
            Class constructorClass=Class.forName("ReflectTest.Student");
            Constructor[] constructors=constructorClass.getDeclaredConstructors();
            System.out.println("构造函数数量："+constructors.length);
            System.out.println("================");
            for(Constructor e:constructors){
                int modify=e.getModifiers();
                System.out.println("修饰符："+ Modifier.toString(modify));
                String constructorName=e.getName();
                System.out.println("构造函数名："+constructorName);
                Class[] parameterTypes=e.getParameterTypes();
                System.out.print("参数:");
                if(parameterTypes.length==0){
                    System.out.println("无参");
                    continue;
                }
                for(Class p:parameterTypes){
                    System.out.print(" "+p.getName());
                }
                System.out.println();
                System.out.println("===================");            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
