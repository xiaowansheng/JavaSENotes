package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式：
 *      实现Callable接口
 *          优点：可以获取线程的执行结果
 *          缺点：效率比较低，在获取线程执行结果的时候，当前线程会受阻塞，效率较低。
 * */
public class ThreadTest16 {
    public static void main(String[] args) {
        //第一步：创建未来任务类
        //参数非常重要：需要给一个Callable接口的实现对象
        FutureTask task=new FutureTask(new MyCallable());

        //创建线程
        Thread t=new Thread(task);

        System.out.println("开始。");

        //启动线程
        t.start();

        //get()；方法将会返回t线程执行的结果
        //但在返回结果之前，当前线程阻塞，需要等待t线程结束，结果返回才会继续执行
        try {
            Object o=task.get();
            //输出返回的对象
            System.out.println("返回对象："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("结束。");
    }
}

class MyCallable implements Callable{

    @Override
    //call方法相当于run方法，只不过有返回值
    public Object call() throws Exception {
        //模拟执行一个任务
        //这个任务返回一个结果
        int sum=0;
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            sum+=i;
        }
        return sum;//自动装箱
    }
}
