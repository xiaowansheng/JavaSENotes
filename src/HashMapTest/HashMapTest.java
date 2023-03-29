package HashMapTest;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        //HashMap
        //非线程安全
        //底层哈希表(散列表)（是一维数组加链表的结合，每一个数组下标下面都是一个单链表）
        //默认初始化长度1<<4=16,默认加载因子0.75，扩容容量是原容量2倍，自定义初始化长度要是2的次方数以提高效率
        //jdk8之后在每一个链表的元素到达8个，链表会变成二叉树，而二叉树元素个数减到6个又会变成单链表
        //基本方法（MapTest中都有说）
        //添加在HashMap的key部分和Set集合中的元素都必须重写equals和hashCode方法。
        //（因为在put和get元素时，都会先调用hashCode计算哈希值，再转换成数组下标(不同哈希值可能会转换成同一个下标值。“哈希碰撞”)，再调用equals比较下标内的各个元素）
        //HashMap集合中允许key和value为null

        HashMap<Student,Grade> ha= new HashMap<Student,Grade>();
        ha.put(new Student(2018313855,"张"),new Grade(88));
        ha.put(new Student(2018313864,"刘"),new Grade(85));
        ha.put(new Student(2018313843,"李"),new Grade(94));
        ha.put(new Student(2018313868,"王"),new Grade(77));
        ha.put(new Student(2018313881,"丁"),new Grade(90));
        System.out.println("size="+ha.size());
        Set<Map.Entry<Student,Grade>> c=ha.entrySet();
        for(Map.Entry<Student,Grade> e:c){
            System.out.println(e.getKey()+","+e.getValue());
        }
    }
}
