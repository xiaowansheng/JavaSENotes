package IteratorTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        //Collection集合及实现类可以调用iteration方法返回一个迭代器。
        //迭代器有三个方法：
        //hasNext，判断是否有下个元素
        //next，返回下一个元素
        //迭代器获取的集合是这个时刻的集合，当数据通过集合操作发生变化时，要重新获取迭代器，否则会出现异常。
        //要对迭代中的集合删除操作可以通过迭代器，就不会出现异常。
        Collection collection=new ArrayList();
        for(int i=0;i<5;i++){
            collection.add(i);
        }
        System.out.println("size="+collection.size());
        Iterator collect=collection.iterator();
        while (collect.hasNext()){
            System.out.println(collect.next());
        }
    }
}
