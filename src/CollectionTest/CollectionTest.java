package CollectionTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        //Collection接口
        //add添加元素
        //size获取元素个数
        //clear清空集合中的元素
        //isEmpty判断是否为空
        //remove删除指定元素（删除的元素判断也是调用equals）
        //contains，判断是否有某个元素（判断底层调用equals）
        //!!!!放在集合中的元素需要重写equals方法

        //
        //List,存储有序，可重复。
        Collection collection=new ArrayList();
        collection.add(1);
        collection.add(1);
        collection.add(1);
        collection.add(2);
        collection.add(2);
        System.out.println(collection.size());//
        collection.remove(2);
        System.out.println(collection.size());
        Iterator l=collection.iterator();
        while (l.hasNext()){
            System.out.println("List="+l.next());
        }

        //Set，存储无序，不可重复。(底层是Map)
        Collection map=new HashSet();
        map.add(2);
        map.add(1);
        map.add(3);
        map.add(1);
        Iterator m=map.iterator();
        while (m.hasNext()){
            System.out.println("map="+m.next());
        }
    }
}
