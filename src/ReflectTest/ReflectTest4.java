package ReflectTest;

/**
 * 研究：Class.forName();发生了什么?
 *      重点：只希望一个类的静态代码块执行，其它代码一律不执行
 *      可以使用：Class.forName("完整类名");
 *              这个方法的执行会导致类加载，类加载时，静态代码块会执行。
 *
 * 提示：后面JDBC技术需要用到
 * */
public class ReflectTest4 {
    public static void main(String[] args) {
        try {
            Class.forName("ReflectTest.MyClass");//获取.class文件的过程会导致类加载
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MyClass{
    static {
        System.out.println("静态代码块执行！");
    }
}