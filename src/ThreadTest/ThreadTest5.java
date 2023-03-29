package ThreadTest;

public class ThreadTest5 {
    public static void main(String[] args) {
        /*
        * 关于线程的sleep()方法：
        *       1，静态方法，Thread.sleep(1000);
        *       2，参数是毫秒
        *       3，作用，让当前线程进入休眠，进入“阻塞”状态，放弃占有的CPU时间片，让给其它线程使用。
        *           出现在哪个线程，哪个线程休眠。
        * */

        //让当前线程休眠5秒钟
        //当前是主线程
//        try {
//            Thread.sleep(1000*5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //5秒后输出
//        System.out.println("Hello world");

        for(int i=0;i<100;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((i+1)+"秒");
        }
    }
}
