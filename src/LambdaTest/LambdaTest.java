package LambdaTest;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 * Lambda表达式的使用：
 *          1、举例：(o1,o2)->Integer.compare(o1,o2);
 *          2、格式：
 *                举例：(o1,o2)->Integer.compare(o1,o2);
 *                  ->：Lambda操作符或箭头操作符
 *                  ->左边：Lambda形参列表（其实就是接口方法中的抽象方法的形参里的列表）
 *                  ->右边：Lambda体（其实就是重写的抽象方法的方法体）
 *          3、Lambda表达式的使用（分6中情况介绍）
 *
 *         总结：
 *          ->左边：Lambda形参列表的类型可以省略（类型推断），如果只有一个参数，小括号（）可以省略
 *          ->右边：Lambda体应该有一对{}包裹，如果lambda只有一条执行语句（可能是return语句），可以省略这一对{}和return关键字
 *
 *          4、Lambda表达式的本质：作为函数接口的实例
 *          5、如果一个接口中、只声明了一个抽象方法，则这个接口称为函数式接口
 */
public class LambdaTest {
    //语法格式（1）无参，无返回值
    @Test
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("我是憨憨");
            }
        };
        r1.run();
        System.out.println("=================================");
        Runnable r2=()-> System.out.println("我是憨憨");
        r2.run();
        System.out.println("*******************************");
    }

    //语法格式（2）：Lambda需要一个参数，但没有返回值
    @Test
    public void test2(){
        Consumer<String> c1=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c1.accept("我是小憨憨");
        System.out.println("==============================");
        Consumer<String> c2=(String s)-> System.out.println(s);
        c2.accept("我是小憨憨");
        System.out.println("**************************");
    }

    //语法格式（3）：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> c1=(String s)-> System.out.println(s);
        c1.accept("我是大憨憨");
        System.out.println("==============================");
        Consumer<String> c2=(s)-> System.out.println(s);
        c2.accept("我是大憨憨");
        System.out.println("**************************");
    }

    @Test
    //语法格式（4）：Lambda若只有一个参数时，参数小括号可以省略
    public void test4(){
        Consumer<String> c2=s-> System.out.println(s);
        c2.accept("我是小大憨憨");
        System.out.println("**************************");
    }

    @Test
    //语法格式（5）：Lambda需要；两个或两个以上参数，多条执行语句，并且可以有返回值
    public void test5(){
        Comparator<Integer> c1=new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                Integer i1=t1;
                Integer i2=t2;
                return i1-i2;
            }
        };
        System.out.println(c1.compare(10,20));
        System.out.println("===========================");
        Comparator<Integer> c2=(t1,t2)->{
            Integer i1=t1;
            Integer i2=t2;
            return i1-i2;};
        System.out.println(c2.compare(20,30));
    }

    @Test
    //语法格式（6）：当Lambda体只有一条语句时，return或大括号若有，都可以省略
    public void test6(){
        Comparator<Integer> c1=(t1,t2)->t1-t2;
        System.out.println(c1.compare(50,30));
    }
}
