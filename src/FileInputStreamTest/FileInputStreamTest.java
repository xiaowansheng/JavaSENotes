package FileInputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream f=null;
        try {
            /**************************************************/
            f=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\char.txt");
//            int n=0;
//            //每次读入一个字节并输出，读到末尾返回-1结束
//            while((n=f.read())!=-1){
//                System.out.println(n);
//            }
            //不关闭流，接下来的读入操作会接着之前的位置继续读入
            /*********************************************/
            byte[] b=new byte[3];
            //读入一个byte数组,返回读入的长度
            int readCount=0;
            while(true){
                readCount=f.read(b);
                if(readCount==-1){
                    break;
                }
                //byte数组转换成字符串并输出，读到多少，转换多少
                System.out.print(new String(b,0,readCount));
            }
            /*********************************************/
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
