package TreeSetTest;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //TreeSet
        //底层调用TreeMap,元素存储在TreeMap的key部分
        //

        TreeSet<Student> ts=new TreeSet<Student>();
        ts.add(new Student(2018355,"AAA"));
        ts.add(new Student(2018354,"BBB"));
        ts.add(new Student(2018362,"CCC"));
        ts.add(new Student(2018361,"DDD"));
        ts.add(new Student(2018358,"EEE"));
        for(Student e:ts){
            System.out.println(e);
        }
    }
}
