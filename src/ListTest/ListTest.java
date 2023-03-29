package ListTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //List
        //add(int index,Object o),指定下标位置添加元素。
        //get(int index),获取指定下标元素
        //set(int index,Object o),修改指定下标元素
        //remove(int index),删除指定下标元素
        //indexOf(Object o),获取元素第一次出现下标
        //lastIndexOf(Object o),获取元素最后一次出现下标
        //

        List li=new ArrayList();
        for(int i=0;i<10;i++){
            li.add(i);
        }
        //Iterator it=li.iterator();
        //List可以用迭代器Iterator或者get,size方法进行遍历。
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i));
        }
        System.out.println("===========");
        li.remove(0);//删除指定下标
        li.remove(Integer.valueOf(1));//删除指定元素
        li.add(8,10);
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i)+"，索引下标："+li.indexOf(i));
        }
    }
}
