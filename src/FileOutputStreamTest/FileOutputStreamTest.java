package FileOutputStreamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream f=null;
        try {
            //当参数中填写的文件不存在的时候会自动新建
            //这种方式是将文件先清空，再重新写入，谨慎使用！
            //f=new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\aaa.txt");
            /*********************/
            //参数中加true，表示以追加到文件末尾的方式写入（看文档）
            f=new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\bbb.txt",true);
            //写入文件
            //b数组对应为（a,b,c,d,e,f）
            byte[] b={97,98,99,100,101,102};
            //把byte中全部字节全部写入
            f.write(b);
            //写入数组部分字节
            //如写入前两个字节
            f.write(b,0,2);
            //写入字符串
            String s="今天是2020年4月15号，星期3，时间0：32。";
            byte[] y=s.getBytes();
            f.write(y);
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
