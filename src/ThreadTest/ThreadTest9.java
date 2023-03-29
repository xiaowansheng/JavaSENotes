package ThreadTest;

/*
* 怎么合理的终止一个程序的执行？
*
*       这种方式很常用。
* */
public class ThreadTest9 {
    public static void main(String[] args) {
        MyRunnable4 r=new MyRunnable4();
        Thread t=new Thread(r);
        t.setName("t");
        t.start();

        //模拟5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止线程
        r.run=false;

    }
}

class MyRunnable4 implements Runnable{

    //打一个boolean标记
    boolean run=true;
    @Override
    public void run() {
            for(int i=0;i<100;i++) {
                if(run){
                    System.out.println(Thread.currentThread().getName() + ":" + i + "秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    //return就结束了，在这之前还有什么没有保存的数据，在这里可以保存。
                    //save...

                    //终止当前线程
                    return;
                }
        }

    }
}