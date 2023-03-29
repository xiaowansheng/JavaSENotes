package FileCopyTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest2 {
    public static void main(String[] args) {
        FileReader fr=null;
        FileWriter fw=null;
        try {
            fr=new FileReader("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt");
            fw=new FileWriter("D:\\java\\IDEACommunity-Project\\javaSE\\新建文件夹\\copy.txt");
            //边读边写
            char[] c=new char[5];
            int readCount=0;
            while((readCount=fr.read(c))!=-1){
                fw.write(c,0,readCount);
            }
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
