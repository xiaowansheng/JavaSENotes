package ObjectInputStreamTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
    public static void main(String[] args) {
        //反序列化
        ObjectInputStream object=null;
        try {
            object=new ObjectInputStream(new FileInputStream("Student"));
            //开始反序列化，读
            //反序列化回来的是个Student对象
            Object student=object.readObject();
            //对象可以调用方法
            System.out.println(student);
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
