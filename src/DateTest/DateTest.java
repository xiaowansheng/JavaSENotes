package DateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date nowTime=new Date();//系统当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");//格式字母不能随便换
        String date=sdf.format(nowTime);
        System.out.println(date);

        long time=System.currentTimeMillis();//自1970年以来的毫秒数
        System.out.println(time);
        Date time2=new Date(1000);
        System.out.println(time2);

        long begin=System.nanoTime();
        System.out.println(begin);


        System.out.println(System.out);
        System.exit(2);
    }
}
