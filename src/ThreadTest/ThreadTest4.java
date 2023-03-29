package ThreadTest;

public class ThreadTest4 {
    public static void main(String[] args) {
        //（1）获取当前对象
        //Thread thread=Thread.currentThread();
        //
        //（2）获取线程名字
        //线程对象.getName();
        //
        //（3）修改线程名字
        //线程对象.setName("线程1");

        //默认线程对象名字：
        //      Thread-0
        //      Thread-1
        //      Thread-2

        //当前方法在main中，所以获取的对象是主线程的对象
        Thread t0=Thread.currentThread();
        //创建线程
        MyThread2 t1=new MyThread2();
        //获取线程名字
        String name=t1.getName();
        System.out.println(name);
        //修改线程名字
        t1.setName("线程1");
        System.out.println(t1.getName());

    }
}

class MyThread2 extends Thread{
    public void run(){
        //哪个线程执行这个run()方法，这个当前对=对象就是哪个线程
        Thread thread=Thread.currentThread();
        for(int i=0;i<1000;i++){
            System.out.println("在分支线程中："+i);
        }
    }
}
