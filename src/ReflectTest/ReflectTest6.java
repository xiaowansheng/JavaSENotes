package ReflectTest;
import java.lang.reflect.Field;

/**
 * 必须掌握：
 *          通过反射机制访问一个java对象的属性
 *          给属性赋值：set
 *          获取属性值：get
 * */
public class ReflectTest6 {
    public static void main(String[] args) {
        //不通过反射机制访问一个类属性
        Student student=new Student();
        //给属性赋值
        student.name="憨憨";
        //读取属性
        System.out.println(student.name);//三要素：1、对象:student 2、属性:name 3、值:憨憨


        //使用反射机制访问一个对象的属性（get、set）
        try {
            Class studentClass=Class.forName("ReflectTest.Student");
            Object obj=studentClass.newInstance();
            //获取name属性（根据属性名称来获取）
            Field nameField=studentClass.getDeclaredField("name");
            //给属性赋值
            //给obj对象（Student类型）的属性name赋值
            nameField.set(obj,"大憨憨");//三要素：1、对象:obj 2、属性:name 3、值:大憨憨
            //获取属性值
            System.out.println(nameField.get(obj));

            //可以访问私有属性吗？这个方法私有属性访问不了
            //属性对象.get(类对象);

            //获取私有属性对象
            Field ageField=studentClass.getDeclaredField("age");

            //给对象赋值//出现异常，private不可以访问
            //ageField.set(obj,20);//出现异常，private不可以访问
            //获取私有属性对象的值
            //ageField.get(obj);//出现异常，private不可以访问

            //打破封装
            ageField.setAccessible(true);
            //给属性赋值
            ageField.set(obj,20);
            //打破封装则可以访问
            System.out.println(ageField.get(obj));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
