package ThreadTest;
/*
* 守护线程
*       线程对象.setDaemon(true);设置为守护线程
* */
public class ThreadTest14 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable8());
        //启动之前，设置为守护线程
        t.setDaemon(true);
        t.setName("守护线程");
        t.start();

        //主线程是用户线程
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
        //用户线程结束，守护线程也会结束

    }
}

class MyRunnable8 implements Runnable{

    @Override
    public void run() {
        int i=0;

        //即使是死循环，因为是守护线程，用户线程结束，守护线程也会跟着结束
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+i++);
        }
    }
}
