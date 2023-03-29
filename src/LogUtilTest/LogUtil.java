package LogUtilTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {
    //日志工具
    //记录日志的方法
    public static void log(String msg){
        try {
            //指向一个日志文件
            PrintStream ps=new PrintStream(new FileOutputStream("D:\\java\\IDEACommunity-Project\\javaSE\\log",true));
            //改变输出方向
            System.setOut(ps);
            //日期当前时间
            Date nowTime=new Date();
            SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm-ss SSS");
            //输出当前时间和信息到日志文件
            System.out.println(time.format(nowTime)+":"+msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
