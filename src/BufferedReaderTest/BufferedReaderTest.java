package BufferedReaderTest;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        //BufferedReader
        //缓冲流
        //带有缓冲区的字符流
        //使用这个流不需要自定义byte数组，char数组。自带缓冲
        FileReader fi=null;
        BufferedReader bf=null;
        try {
            fi=new FileReader("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt");
            //当一个流的构造方法中需要传入一个流时，被传入的流叫做：节点流
            //外面负责包装的这个流，叫：包装流，或者叫： 处理流
            //这里FileReader就是节点流，BufferedReader就是包装流|处理流
            //对于包装流来说，只需要关闭最外层的流，里面的流会自动关闭（看源码）
            bf=new BufferedReader(fi);
            String s=null;
            //每次读入一行并输出
            while ((s=bf.readLine())!=null){
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
