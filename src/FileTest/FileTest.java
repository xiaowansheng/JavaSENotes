package FileTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        //File
        //（1）和四大家族没有关系，所以File类能完成文件的读和写
        //（2）File对象代表什么？
        //      文件和路径名的抽象表示
        //      一个File对象表示一个路径或者一个文件
        //（3）需要掌握File中的几个常用方法

        //创建File对象
        File f1=new File("D:\\java\\IDEACommunity-Project\\javaSE\\aaa.txt");
        //判断是否存在
        System.out.println(f1.exists());

        //如果不存在则以文件的形式创建
        File f2=new File("D:\\java\\IDEACommunity-Project\\javaSE\\fff");
        if(!f2.exists()){
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //如果不存在则以路径的形式创建
        File f3=new File("D:\\java\\IDEACommunity-Project\\javaSE\\fff");
        if(!f3.exists()){
            f3.mkdir();
        }

        //多重目录创建
        File f4=new File("D:\\java\\IDEACommunity-Project\\javaSE\\a\\b\\c\\d");
        if(!f4.exists()){
            f4.mkdirs();
        }

        //获取父路径
        File f5=new File("D:\\java\\IDEACommunity-Project\\javaSE");
        //获取String类型的路径
        String parentPath=f5.getParent();
        System.out.println("f5的父路径是："+parentPath);
        //获取File类型的路径
        //获取绝对路径
        File parentFile=f5.getParentFile();
        System.out.println("绝对路径："+parentFile.getAbsolutePath());

        //绝对路径
        File f6=new File("D:\\java\\IDEACommunity-Project\\javaSE\\log");
        System.out.println("f6绝对路径："+f6.getAbsolutePath());

        //返回对象文件（文件夹）名
        File f7=new File("D:\\java\\IDEACommunity-Project\\javaSE\\aaa.txt");
        System.out.println(f7.getName());

        //判断是否是一个目录
        //判断是否是一个文件
        File f8=new File("D:\\java\\IDEACommunity-Project\\javaSE");
        System.out.println("是否是目录："+f8.isDirectory());
        System.out.println("是否是文件："+f8.isFile());

        //获取文件最后修改时间
        File f9=new File("D:\\java\\IDEACommunity-Project\\javaSE\\copy.txt");
        long l=f9.lastModified();//返回的是从1970年以来的毫秒数，long类型
        System.out.println(l);
        //转换为时间
        Date d=new Date(l);
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("文件最后修改时间："+s.format(d));

        //获取文件的大小
        //返回的是字节数
        System.out.println("文件大小："+f9.length());
    }
}
