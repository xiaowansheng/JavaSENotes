package ThreadTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
* *使用定时器指定定时任务
*       Timer类（看文档）
* */
public class ThreadTest15 {

    public static void main(String[] args) {
        //编辑定时器对象
        Timer timer=new Timer();
        //守护线程的方式
        //Timer timer=new Timer(true);

        //指定定时任务
        //timer.schedule(定时任务,第一次执行时间,间隔多久执行一次);

        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time=null;
        try {
            time=s.parse("2020-4-18 23:21:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //十秒钟执行一次记录任务，从time时间开始
        timer.schedule(new LogTimerTask(),time,1000*10);
    }
}

//编写定时任务类，需要继承抽象类TimerTask
//假设这是一个定时记录日志的定时任务
class LogTimerTask extends TimerTask {

    @Override
    public void run() {
        Date time=new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(s.format(time)+":成功完成一次数据备份。");
    }
}