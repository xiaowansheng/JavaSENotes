package ReflectTest;
/**
 *Class能干嘛？
 *      通过Class的newInstance();方法来实例化对象。
 *          注意：newInstance();方法是调用无参构造函数构造实例，必须保证无参构造存在才可以实例化对象。
 *              否则出现异常。
 */
public class ReflectTest2 {
    public static void main(String[] args) {
        ///不使用反射创造对象
        User u=new User();
        System.out.println(u);

        //用反射机制方式构造对象
        try {
            Class c=Class.forName("ReflectTest.User");
            Object o=c.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
