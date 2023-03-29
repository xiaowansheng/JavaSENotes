package ObjectInputStreamTest;

import ObjectOutputStreamTest.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamTest2 {
    public static void main(String[] args) {
        //反序列化集合
        ObjectInputStream object=null;
        try {
            object=new ObjectInputStream(new FileInputStream("Students"));
            //Object o=object.readObject();
            //System.out.println(o instanceof List);//true
            List<Student> students=(List<Student>) object.readObject();
            for(Student e:students){
                System.out.println(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
