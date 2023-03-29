package ThreadTest;


//实现多线程的第一种方式：
//      编写一个类，继承java.lang.Thread,重写run方法
//          创建线程对象，new就可以
//          启动线程，调用线程对象的start()方法

//注意：
//    亘古不变的道理：
//          方法体中的代码永远都是自上而下按顺序依次执行的。
public class ThreadTest {
    public static void main(String[] args) {
        //这里是main方法，这里的代码属于主线程，在主栈中运行
        //这里创建一个线程对象
        MyThread myThread=new MyThread();
        //启动线程
        //start()方法的作用是启动一个分支线程，在jvm中新开辟一个栈空间，这段代码任务完成后，瞬间就结束了。
        //这段代码的任务只是为了开辟一个新的栈空间，只要新的栈空间开辟出来了，start()方法就结束了，线程就启动成功了。
        //启动成功的线程会自动调用run()方法，并且Run方法在分支栈的栈底部（压栈）。
        //run方法在分支栈的栈底部，main方法在主栈的栈底部。run和main是平级的。
        myThread.start();
        //myThread.run();//这里不会启动线程，不会分配新的分支栈（这种方式是单线程）。
        //这里的方法还是运行在主线程中
        for(int i=0;i<1000;i++){
            System.out.println("在主线程中："+i);
        }
    }
}

class MyThread extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("在分支线程中："+i);
        }
    }
}