package ReflectTest;

/**
 *
 * 重点：获取一个类的父类以及实现的接口
 */
public class ReflectTest11 {
    public static void main(String[] args) {

        //String举例
        try {
            ///获取class文件
            Class stringClass=Class.forName("java.lang.String");
            Class superString=stringClass.getSuperclass();
            System.out.println("String的父类："+superString.getSimpleName());
            Class[] interfaceString=stringClass.getInterfaces();
            System.out.print("String实现的接口：");
            for(Class e:interfaceString){
                System.out.print("["+e.getSimpleName()+"]");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
