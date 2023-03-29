package ObjectOutputStreamTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamTest2 {
    public static void main(String[] args) {
        //可以一次序列化多个对象
        //  将对方放在集合中，一次序列化一个集合
        //参与序列化的集合ArrayList和集合中的类Student，都需要实现java.io.Serializable接口。
        List<Student> students=new ArrayList<Student>();
        students.add(new Student("李憨憨",'女',19));
        students.add(new Student("丁憨憨",'女',20));
        students.add(new Student("大憨憨",'男',21));
        students.add(new Student("小憨憨",'女',19));
        ObjectOutputStream object=null;
        try {
            object=new ObjectOutputStream(new FileOutputStream("Students"));
            object.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(object!=null){
                try {
                    object.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
