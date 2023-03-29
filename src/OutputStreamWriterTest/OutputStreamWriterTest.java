package OutputStreamWriterTest;

import java.io.*;

public class OutputStreamWriterTest {
    public static void main(String[] args) {
        //字节流
        FileOutputStream fo=null;
        //转换流
        OutputStreamWriter ot=null;
        //缓冲流
        BufferedWriter bf=null;
        try {
//            fo=new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\ccc.txt");
//            ot=new OutputStreamWriter(fo);
//            bf=new BufferedWriter(ot);
            bf=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\ccc.txt")));
            bf.write("现在是2020/4/15/18：12");
            bf.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bf!=null){
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
