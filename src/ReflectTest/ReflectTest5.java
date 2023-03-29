package ReflectTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射Student中的所有Field
 * */
public class ReflectTest5 {
    public static void main(String[] args) {
        try {
            //获取整个类
            Class studentClass=Class.forName("ReflectTest.Student");
            System.out.println("完整类名"+studentClass.getName());
            System.out.println("类名（简写）"+studentClass.getSimpleName());
            //获取类中的所有Field

            //获取所有的public修饰的Field
            //Field[] fields=studentClass.getFields();

            //获取所有的Field，包括private修饰的
            Field[] fields=studentClass.getDeclaredFields();
            System.out.println("测试数组元素个数（属性个数）："+fields.length);
            System.out.println("================");
            for(Field e:fields){
                //获取修饰符代号
                int modify=e.getModifiers();//返回修饰符是一个数字每个数字是修饰符代号
                //获取修饰符名
                String modifyName=Modifier.toString(modify);
                System.out.println("修饰符："+ modifyName);
                //获取属性的类型
                Class type=e.getType();
                //获取属性的类型名
                String typeName=type.getName();
                System.out.println("属性类型："+typeName);
                //获取属性名
                String fieldName=e.getName();
                System.out.println("属性名："+fieldName);
                System.out.println("===================");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
