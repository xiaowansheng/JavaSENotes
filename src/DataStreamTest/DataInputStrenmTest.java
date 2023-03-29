package DataStreamTest;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStrenmTest {
    public static void main(String[] args) {
        //java.io.DataInputStream:数据专属的输入流
        //读的时候要知道读取顺序和格式（输入的格式顺序）
        //根据输入的格式和顺序，才能依次将数据读取出来
        DataInputStream d = null;
        try {
            d = new DataInputStream(new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\data"));
            System.out.println(d.readByte());
            System.out.println(d.readShort());
            System.out.println(d.readInt());
            System.out.println(d.readLong());
            System.out.println(d.readFloat());
            System.out.println(d.readDouble());
            System.out.println(d.readBoolean());
            System.out.println(d.readChar());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (d != null) {
                try {
                    d.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}