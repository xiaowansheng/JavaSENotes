package DataStreamTest;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {
    public static void main(String[] args) {
        //java.io.DataOutputStream:数据专属的输出流
        //这个流可以将数据和数据类型一并写入文件
        //注意：这个文件不是普通文档（也不能用记事本打开）
        //!!什么顺序和格式输入，就要以什么顺序格式输出！！
        DataOutputStream d=null;
        try {
            d=new DataOutputStream(new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\data"));
            byte b=100;
            short s=200;
            int i=300;
            long l=400;
            float f=3.14f;
            double db=3.1415926;
            boolean bl=true;
            char c='a';
            d.writeByte(b);
            d.writeShort(s);
            d.writeInt(i);
            d.writeLong(l);
            d.writeFloat(f);
            d.writeDouble(db);
            d.writeBoolean(bl);
            d.writeChar(c);
            d.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(d!=null){
                try {
                    d.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
