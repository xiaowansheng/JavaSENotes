package TreeMapTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        //TreeMap
        //底层是个二叉树
        //TreeSet底层是一个TreeMap，放到TreeSet中的元素相当于放到TreeMap中的key部分
        //无序不可重复，但可按照元素大小自动排序，称可排序集合

        //排序方式
        //（1）
        //排序比较规则是，实现Comparable接口中的comparaTo方法，用comparaTo比较
        //插入自定义类需要实现Comparable接口，否则会出现异常
        //在comparaTo中，需要自定义比较逻辑比较规则。
        //（2）
        //编写一个比较器，实现比较器comparator接口
        //把比较器当作参数传入到TreeMap集合或TreeSet集合中（看源码构造函数）
        //当插入元素排序的时候会调用比较器进行比较（看源码）

        //comparable和comparator所属的包名不一样
        //两种比较方法选择：比较规则不变选第一种，比较规则会改变选第二种

        TreeMap<Student,Integer> tm=new TreeMap<Student,Integer>();
        tm.put(new Student(2018366,"aaa"),88);
        tm.put(new Student(2018363,"bbb"),93);
        tm.put(new Student(2018364,"ccc"),76);
        tm.put(new Student(2018345,"ddd"),85);
        tm.put(new Student(2018355,"fff"),95);
        Collection<Student> c=tm.keySet();
        for(Student e:c){
            System.out.println(e);
        }
        ArrayList<Integer> arr=new ArrayList(tm.values());
        arr.sort(new NumberCompare());
        for(Integer e:arr){
            System.out.println(e);
        }
    }
}