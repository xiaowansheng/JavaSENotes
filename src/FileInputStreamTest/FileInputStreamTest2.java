package FileInputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
    public static void main(String[] args) {
        FileInputStream f=null;
        try{
            f=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\HelloWorld\\src\\FileInputStreamTest\\HelloWorld.java");
            byte[] b=new byte[5];
            int readCount=0;
            while ((readCount=f.read(b))!=-1){
                System.out.print(new String(b,0,readCount));
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
