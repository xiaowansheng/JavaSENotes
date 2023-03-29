package ThreadTest;

/*
* 怎么强行终止一个线程？（注意：是结束线程的执行）
*       这种方式有很大缺陷：容易丢失数据。因为这种方式直接将线程杀死了
*       线程中没用保存的数据将会丢失。
*       不建议使用！
* */
public class ThreadTest8 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable3());
        t.start();

        //5秒后终止t线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止t线程
        t.stop();//已过时，不建议使用


    }

}

class MyRunnable3 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i + "秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
