package ObjectOutputStreamTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        //参与序列化和反序列化的对象必须实现Serializable接口
        //否则会出现java.io.NotSerializableException异常
        //注意：通过源代码发现Serializable只是个标志接口
        //public interface Serializable {
        //}
        //这个接口中没用任何代码
        //作用：起到标识、标志作用，java虚拟机看到这个类实现了这个接口，可能会对这个类特殊待遇
        //      这个Serializable标志接口是给java虚拟机参考的，
        //      java虚拟机看到这个接口后，如果类中没有写序列化版本号号，则会为该类自动生成一个序列化版本号
        //
        //序列化版本号作用：
        //  如果源码改动了，随机生成的序列化版号会发生改变，反序列化将出现异常
        //  java区分类是先进行比较类名，类名相同，再比较序列化版本号,就能将类区分开

        //自动生成序列化版本号有什么缺陷？
        //      一旦代码确定，将不能进行后续的修改
        //      因为一旦修改，将重新编译，此时将会重新生成新的序列化版本号
        //      这时，java虚拟机将会认为这是一个全新的类。
        //      （这样以前的序列化文件将不能成功进行反序列化）

        //结论：
        //  凡是一个类实现了Serializable接口，建议给该类提供一个固定不变的序列化版本号
        //  这样，及时以后这个类代码修改了，但是版本号不变，java虚拟机会认为是同一个类

        // transient关键字，表示游离的，不参与序列化

        //创建java对象
        Student student=new Student("憨憨",'男',20);
        //序列化
        ObjectOutputStream object=null;
        try {
            object=new ObjectOutputStream(new FileOutputStream("Student"));
            //序列化对象
            object.writeObject(student);
            //刷新
            object.flush();
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
