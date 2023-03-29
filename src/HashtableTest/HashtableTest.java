package HashtableTest;

import java.util.Hashtable;

public class HashtableTest {
    public static void main(String[] args) {
        //Hashtable
        //线程安全（效率较低，使用较少）
        //Hashtable和HashMap一样底层都是哈希表数据结构
        //默认初始化容量11，默认加载因子0.75，扩容是原容量2倍+1
        //key值不允许为空
        //value也不可以为空

        Hashtable t=new Hashtable();
        //空值异常
        //t.put(null,null);
        System.out.println(t.size());
    }
}
