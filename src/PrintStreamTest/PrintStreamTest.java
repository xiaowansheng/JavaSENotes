package PrintStreamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        //java.io.PrintStream:标准的字节输出流。
        //默认输出到控制台
        //标准输出流不需要手动关闭

        //联合写
        System.out.println("哈哈哈哈");
        //分开写
        PrintStream p=System.out;
        p.println("哈哈哈哈");
        p.println(100);
        p.println(3.14);
        System.out.println("p="+p);

        //之前学习使用过的属性
//        System.exit();
//        System.currentTimeMillis();
//        System.gc();
//        System.arraycopy();
//        System.out

        try {
            //标准输出不再指向控制台，指向其他文件
            PrintStream ps=new PrintStream(new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\logTest"));
            //修改输出方向，将输出方向修改到“logTest”文件
            System.setOut(ps);
            //再输出将会直接输出到文件内
            System.out.println("现在是2020年4月15号，22：56。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
