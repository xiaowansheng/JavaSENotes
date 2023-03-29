package LambdaTest;

import HashMapTest.Student;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 *  方法引用的使用：
 *          1、使用场景：当要传递给Lambda体的操作，已经有实现方法了。可以使用方法引用。
 *          2、方法引用本质是Lambda表达式，而Lambda表达式作为函数式接口的实例出现，
 *              所以方法引用也是函数式接口的实例
 *          3、使用格式：   类（或对象）：：方法名
 *          4、具体分为三种情况：
 *            (情况1)  对象：：非静态方法
 *           （情况2）  类：：静态方法
 *           （情况3）类：：非静态方法
 *
 *          5、方法引用的使用要求：要求接口中的抽样方法的形参列表和返回值与引用方法的形参列表和返回值相同。（主要针对情况1、2）
 *
 */
public class MethodRefTest {

    //情况（1）对象：：实例方法

    //Consumer中的void accept（T t）
    //PrintStream中的偶void println（T t）
    @Test
    public void test1(){
        Consumer<String> con1= s->System.out.println(s);
        con1.accept("我是憨憨");
        System.out.println("=========================");
        PrintStream out=System.out;
        Consumer<String> con2=out::println;
        con2.accept("我是憨憨");
        System.out.println("******************");
    }

    //Supplier中的T get（）
    //Employee中的String getName（）
    @Test
    public void test2(){
        Student stu=new Student(2018313,"憨憨");

        Supplier<String> s1=()->stu.getName();
        System.out.println(s1.get());
        System.out.println("=============================");
        Supplier<String> s2=stu::getName;
        System.out.println(s2.get());
        System.out.println("*********************");
    }

    //情况（2） 类：：静态方法

    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare（T t1，T t2）
    @Test
    public void test3(){
        Comparator<Integer> com1=(t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(10,20));
        System.out.println("=======================");
        Comparator<Integer> com2=Integer::compareTo;
        System.out.println(com2.compare(100,50));
        System.out.println("********************");
    }

    //Function中的R apply（T t）
    //Math中的Long round（double d）
    @Test
    public void test4(){
        Function<Double,Long> fun1=d->Math.round(d);
        System.out.println(fun1.apply(3.15159));
        System.out.println("=====================");
        Function<Double,Long> fun2=Math::round;
        System.out.println(fun2.apply(3.15159));
        System.out.println("********************");
    }

    //情况（3）：类：：实例方法（有难度）

    //Comparator中的int compare（T t1，Tt2）
    //String中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com1=(t1,t2)->t1.compareTo(t2);
        System.out.println(com1.compare("abc","abC"));
        System.out.println("==================");
        Comparator<String> com2=String::compareTo;
        System.out.println(com2.compare("abc","abe"));
    }

}
