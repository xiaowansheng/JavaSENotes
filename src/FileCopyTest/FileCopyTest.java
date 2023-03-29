package FileCopyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
    public static void main(String[] args) {
        //文件拷贝
        //需要一个输入流，一个输入流
        //读入到内存中，再写到硬盘中
        //边读边写
        //用字节流拷贝文件，万能，什么文件都可以拷贝
        FileInputStream fi=null;
        FileOutputStream fo=null;
        try {
            fi=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt");
            fo=new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\新建文件夹\\copy.txt");
            //每次读入5字节，写入5字节
            byte[] b=new byte[5];
            int readCount=0;
            while ((readCount=fi.read(b))!=-1){
                fo.write(b,0,readCount);
            }
            fo.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //两个流分开try，不然其中一个流异常，影响另一个流的关闭
            if(fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
