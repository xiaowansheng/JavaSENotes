package ThreadTest;

/*
* 线程合并
* */
public class ThreadTest12 {
    public static void main(String[] args) {
        System.out.println("begin");

        Thread t=new Thread(new MyRunnable7());
        t.start();
        //合并线程
        try {
            t.join();//t线程合并到当前线程中，当前线程受阻，等待t线程结束才会执行当前线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println("end");
    }
}

class MyRunnable7 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
