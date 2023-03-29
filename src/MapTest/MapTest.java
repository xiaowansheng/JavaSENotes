package MapTest;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        //Map
        //Mpa和Collection没有继承关系
        //存K-V对，都是引用数据类型，K和V都是存内存地址
        //无序不可重复
        //size(),返回键值对的对数
        //put(K key,V value),插入键值对,如果有相同Key则更新value，函数返回旧的value值，如果插入的是新的键值对，则函数返回null。
        //get(K key),返回key所对应的value值
        //remove(k key),通过键删除键值对
        //isEmpty(),是否为空
        //clear(),清空元素
        //containsKey(K key),是否有这个key键
        //containsValue(V value)，是否有这个value值
        //values(),获取所有的value，返回一个Collection集合，集合类型是value类型，元素值是Map中的value值
        //keySet(),获取所有的key，返回一个Set集合，集合类型是key类型，元素值是Map中的key值。
        //entrySet(),返回一个Set集合，Set集合中的元素类型是Map.Entry<K,V>。Map.Entry中Entry是Map的静态内部类

        //遍历Map
        //非常重要
        //(1)
        //keySet(),获取所有的key，返回一个Set集合，集合类型是key类型，元素值是Map中的key值。
        //(2)(直接用Node节点获取数据，比第一种效率高)(适合大数据量)
        //entrySet(),返回一个Set集合，Set集合中的元素类型是Map.Entry<K,V>。
        //每一个元素都是一个Node节点类，每个Node都有key和value属性,遍历就是每次取出一个Node。（看源码）
        //Map.Entry中Entry是Map的静态内部类


        Map<Integer,String> m=new HashMap<>();
        m.put(1,"yi");
        m.put(2,"er");
        m.put(3,"san");
        m.put(4,"si");
        m.put(5,"wu");
        m.put(6,"liu");
        //插入新的key，返回的是null
        System.out.println("旧值为："+m.put(7,"qi"));
        //key相同，则更新value值,返回旧value值，不会增加新的键值对。
        System.out.println("旧值value="+m.put(7,"0")+"，更改为新值value="+m.get(7));
        System.out.println("size="+m.size());
        //返回一个Set集合
        Set c=m.entrySet();
        for(Object e:c){
            System.out.println(e);
        }
        System.out.println("是否有key="+2+":"+m.containsKey(2));
        System.out.println("是否有value="+"\"wu\":"+m.containsValue("wu"));
        Collection<String> s=m.values();
        for(String e:s){
            System.out.print(e+" ");
        }

        System.out.println();
        System.out.println("==========");
        Set<Map.Entry<Integer,String>> set=m.entrySet();
        for(Map.Entry<Integer,String> e:set){
            System.out.println(e);
        }
        System.out.println("===========");
        Iterator<Map.Entry<Integer,String>> it=set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> en=it.next();
            Integer in=en.getKey();
            String st=en.getValue();
            System.out.println(in+"="+st);
        }
    }
}
