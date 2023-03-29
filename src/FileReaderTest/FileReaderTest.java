package FileReaderTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        //字符流读取
        //只能读取文本文件
        FileReader f=null;
        try {
            f=new FileReader("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt");
            //一次读取5个字符
            char[] c=new char[5];
            int readCount=0;
            while((readCount=f.read(c))!=-1){
                System.out.print(new String(c,0,readCount));
            }
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
