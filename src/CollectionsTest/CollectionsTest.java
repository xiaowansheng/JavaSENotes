package CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;

public class CollectionsTest {
    public static void main(String[] args) {
        //Collections
        //集合工具类
        //可以对集合进行操作
        //与Collection不同，Collection是接口
        ArrayList<Grade> g=new ArrayList<Grade>();
        g.add(new Grade(2018313869,"张三",88));
        g.add(new Grade(2018313880,"李四",90));
        g.add(new Grade(2018313855,"王五",76));
        g.add(new Grade(2018313878,"小六",85));
        g.add(new Grade(2018313864,"憨憨",77));
        Collections.sort(g);
        for(Grade e:g){
            System.out.println(e);
        }
        System.out.println("===============");
        Collections.sort(g,new GradeCompare());
        for(Grade e:g){
            System.out.println(e);
        }
    }
}

class GradeCompare implements Comparator<Grade>{
    @Override
    public int compare(Grade g1, Grade g2) {
        return g1.getGrade()-g2.getGrade();
    }
}