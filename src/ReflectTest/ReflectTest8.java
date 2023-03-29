package ReflectTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 重点：必须掌握（很重要）
 *
 *
 *      反射机制让代码更有通用性，可变化内容写配置文件里，
 *      修改配置文件就可以让创建的对象可以不一样，调用的方法也不同，
 *      而且java代码可以无需任何改动。
 */
public class ReflectTest8 {
    public static void main(String[] args) {
        //不通过反射机制调用方法
        //创建对象
        UserService userService=new UserService();
        //调用方法
        boolean state=userService.login("admin","123");
        System.out.println(state?"登录成功！":"登录失败!");

        //调用方法四要素：1、对象 2、方法名 3、参数 4、返回值

        //使用反射机制调用方法
        try {
            //获取class文件
            Class userServiceClass=Class.forName("ReflectTest.UserService");
            //新建对象
            Object obj=userServiceClass.newInstance();
            //获取Method
            Method loginMethod=userServiceClass.getDeclaredMethod("login",String.class,String.class);
            //调用方法（需要四要素）
            /**
             * 反射中的最最重要的方法！！！！！！！！！！！！！！
             * userServiceClass：对象
             * loginMethod：方法
             * "admin","123"：两个实参
             * retValue：返回值
             * */
            Object retValue=loginMethod.invoke(userServiceClass,"admin","123");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
