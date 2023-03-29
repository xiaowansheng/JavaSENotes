package ThreadTest;
/*
* 线程让位
* */
public class ThreadTest11 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnnable6());
        t.start();
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class MyRunnnable6 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            //每100次让位一次
            if(i%100==0){
                Thread.yield();//当前线程暂停一下，让给主线程
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}