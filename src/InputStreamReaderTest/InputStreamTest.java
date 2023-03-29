package InputStreamReaderTest;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) {
        //字节流
        FileInputStream fi=null;
        //转换流
        InputStreamReader is=null;
        //缓冲字符流
        BufferedReader bf=null;
        try {
            //字节流
            fi=new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt");
            //通过转换流InputStreamReader，将字节流转换为字符流
            //fi节点流，is包装流
            is=new InputStreamReader(fi);
            //缓冲流，只能传字符流，不能传字节流
            //is节点流，bf包装流
            bf=new BufferedReader(is);
            //合并写
            //bf=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt")));
            String s=null;
            while((s=bf.readLine())!=null){
                System.out.println(s);
            }
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
