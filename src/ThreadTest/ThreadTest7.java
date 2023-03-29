package ThreadTest;

/*
* 如何唤醒一个长时间睡眠的线程？
*   叫醒在sleep()睡眠中的线程？
*       终止睡眠？
* */
public class ThreadTest7 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable2());
        t.start();
        System.out.println("主线程开始！");
        //假如需要在主线程要做完某件事之后才需要继续执行分支线程
        //主线程做这件事大概需要5秒
        //而让分支线程在这期间一直在睡眠
        //在主线程完成后才需要唤醒分支线程，让分支开始执行

        //假设五秒做完
        //希望五秒后，分支线程醒来
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("事情做完。");
        //主线程这件事做完后唤醒分支线程
        //中断线程睡眠（这种中断方式靠的是java异常处理机制）
        t.interrupt();
    }
}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        System.out.println("分支线程进入长时间睡眠！");
        //线程沉睡一天
        try {
            Thread.sleep(1000*60*60*24);
        } catch (InterruptedException e) {
            //打印异常信息
            e.printStackTrace();
        }
        //正常情况一天后才会执行这行代码
        System.out.println("分支线程结束。");
    }
}
