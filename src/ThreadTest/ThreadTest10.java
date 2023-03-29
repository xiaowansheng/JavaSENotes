package ThreadTest;

/*
* 关于线程的优先级
* */
public class ThreadTest10 {
    public static void main(String[] args) {
        System.out.println("最低优先级："+Thread.MIN_PRIORITY);
        System.out.println("默认优先级："+Thread.NORM_PRIORITY);
        System.out.println("最高优先级："+Thread.MAX_PRIORITY);

        Thread t=new Thread(new MyRunnable5());

        //获取优先级
        System.out.println(Thread.currentThread().getName()+"默认优先级"+Thread.currentThread().getPriority());
        System.out.println(t.getName()+"默认优先级"+t.getPriority());
        //更改优先级
        Thread.currentThread().setPriority(1);
        t.setPriority(10);

        //优先级较高的只是抢到的时间片多一些
        //大概率抢到时间片也偏向优先级高的

        t.start();

        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class MyRunnable5 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}