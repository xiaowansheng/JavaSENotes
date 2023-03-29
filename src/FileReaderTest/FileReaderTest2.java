package FileReaderTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest2 {
    public static void main(String[] args) {
        //遍历字符
        FileReader chars=null;
        try {
            chars=new FileReader("D:\\java\\IDEACommunity-Project\\javaSE\\bbb.txt");
            char[] c=new char[5];
            chars.read(c);
            for(char e:c){
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(chars!=null){
                try {
                    chars.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
