package FileWriterTest;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        //写入字符，字符串
        FileWriter f=null;
        try {
            f=new FileWriter("D:\\java\\IDEACommunity-Project\\javaSE\\新建文件夹\\www.txt");
            char[] c={'我','是','一','个','中','国','人'};
            f.write(c);
            f.write('\n');
            f.write("今天是2020年，4月15号，星期三，16：17");
            f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
