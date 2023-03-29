package FileTest;

import java.io.File;

public class FileTest2 {
    public static void main(String[] args) {
        //获取目标文件夹下的目录（文件和文件夹）
        File f=new File("D:\\java\\IDEACommunity-Project\\javaSE");
        File[] fs=f.listFiles();
        for(File e:fs){
            System.out.println(e.getAbsolutePath());
        }
    }
}
