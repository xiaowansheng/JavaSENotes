package FileInputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest4 {
    public static void main(String[] args) {
        FileInputStream f=null;
        try{
            f=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\char.txt");
            //跳过指定字节数
            System.out.println("总字节数："+f.available());
            System.out.println("跳过字节数："+4);
            f.skip(4);
            byte[] b=new byte[f.available()];
            System.out.println("读入字节数："+f.read(b));
            System.out.println("输出读入的剩余字节数："+new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(f!=null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
