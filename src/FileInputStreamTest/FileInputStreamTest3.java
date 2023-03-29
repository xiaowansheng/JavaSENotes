package FileInputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest3 {
    public static void main(String[] args) {
        FileInputStream f=null;
        try{
            f=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\HelloWorld\\src\\FileInputStreamTest\\HelloWorld.java");
            //返回剩余的字节数
            System.out.println("文件的字节数："+f.available());
            //可以这样用：根据剩余字节数直接读一次就能读完
            //这种方法不适用于大文件，因为byte数组不能太大
            byte[] b=new byte[f.available()];
            int readCount=f.read(b);
            System.out.println(new String(b));
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
