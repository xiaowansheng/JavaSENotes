package ReflectTest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射类中的所有Method
 *
 */
public class ReflectTest7 {
    public static void main(String[] args) {

        try {
            Class peopleClass=Class.forName("ReflectTest.People");
            Method[] methods=peopleClass.getDeclaredMethods();
            System.out.println("方法数量："+methods.length);
            System.out.println("=====================");
            for(Method e:methods){
                int modify=e.getModifiers();
                System.out.println("方法修饰符："+ Modifier.toString(modify));
                String methodName=e.getName();
                System.out.println("方法名："+methodName);
                System.out.print("参数:");
                Class[] parameterTypes=e.getParameterTypes();
                if(parameterTypes.length==0){
                    System.out.print("没有参数");
                    System.out.println();
                    System.out.println("===================");
                    continue;
                }
                for(Class p:parameterTypes){
                    System.out.print(" "+p.getSimpleName());
                }
                System.out.println();
                System.out.println("===================");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
