package ThreadTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、使用wait和notify方法实现”生产者和消费者模式“
 *          生产线程负责生产，消费线程负责消费
 *          生产线程和消费线程要达到均衡
 *          是一种特殊业务需求，在这种特殊情况下需要使用wait方法和notify方法
 *
 * 2、wait和notify方法不是线程方法，是普通java对象都有的方法
 *
 * 3、wait方法和notify是建立在线基础之上的。因为多线程要同时操控一个仓库。有线程安全问题。
 *
 * 4、wait方法作用：o.wait();让正在o对象上活动的线程进入等待状态，并且释放掉这个线程在之前占用的o对象的对象锁。
 *
 * 5、noyifu方法的作用：o.notify();方法让正在o对象上等待的线程唤醒，只是通知，不会释放o对象上之前占有的锁。
 * */
public class ThreadTest17 {
    public static void main(String[] args) {
        //用集合来装产品
        List commodity=new ArrayList();
        //创建生产线程
        Thread t1=new Thread(new Production(commodity));
        t1.setName("生产线程");
        //创建消费线程
        Thread t2=new Thread(new Consumption(commodity));
        t2.setName("消费线程");

        //启动线程
        t1.start();
        t2.start();
    }
}

//产品类
class Commodity{
    private String name;

    public Commodity() {
    }

    public Commodity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//生产线程
class Production implements Runnable{

    List commodity;

    public Production(List Commodity) {
        this.commodity = Commodity;
    }

    @Override
    //商品空了才开始生产，满了才开始消费
    public void run() {
        while(true){
            synchronized (commodity){
                if(commodity.size()==10){
                    try {
                        System.out.println("仓库已满，等待消费。。。");
                        commodity.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("进入生产状态：");

                //生产产品需要0.8秒
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //装仓库需要0.2秒
                commodity.add(new Object());
                System.out.println("商品+1");
                System.out.println("商品数："+commodity.size());
                commodity.notifyAll();
            }
        }
    }
}

//消费线程
class Consumption implements Runnable{

    List commodity;

    public Consumption(List Commodity) {
        this.commodity = Commodity;
    }

    @Override
    //商品空了才开始生产，满了才开始消费
    public void run() {
        while(true){
            synchronized (commodity){
                if(commodity.size()==0){
                    try {
                        System.out.println("仓库已空，等待生产。。。");
                        commodity.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("进入消费状态");

                //消费商品需要0.5秒
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                commodity.remove(0);
                System.out.println("商品-1");
                System.out.println("商品数："+commodity.size());
                commodity.notifyAll();
            }

//            等待一会，生产线程将抢到锁
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}