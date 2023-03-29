package ThreadTest;

public class ThreadTest6 {
    public static void main(String[] args) {

        //关于Thread.sleep()方法的一个面试题

        MyThread6 t=new MyThread6();
        t.start();

        try {
            //问题：这行代码会让t线程进入休眠吗？？
            t.sleep(5000);
            //不会！！
            //因为sleep()是静态方法
            //在执行的时候还是会转换成Thread.sleep(5000)
            //这行代码出现在main方法中
            //也就是说是main方法进入休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5秒之后才会输出
        System.out.println("Hello World");

    }
}

class MyThread6 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("分支线程："+i);
        }
    }
}
