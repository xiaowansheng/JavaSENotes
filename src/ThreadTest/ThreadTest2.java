package ThreadTest;

public class ThreadTest2 {
    public static void main(String[] args) {
        //实现多线程的第二种方式：
        //      编写一个类，实现runnable接口，实现run方法

        //创建一个可运行的对象
        //MyRunnable myRunnable=new MyRunnable();
        //将一个可运行的对象封装成一个线程对象
        //Thread thread=new Thread(myRunnable);
        //合并代码
        Thread thread=new Thread(new MyRunnable());
        //启动线程
        thread.start();

        for(int i=0;i<1000;i++){
            System.out.println("在主线程中："+i);
        }
    }
}

//这并不是一个线程类，是一个可运行的类。它还不是一个线程。
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            System.out.println("在分支线程中：" + i);
        }
    }
}
