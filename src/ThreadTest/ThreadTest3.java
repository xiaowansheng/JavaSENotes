package ThreadTest;

public class ThreadTest3 {
    public static void main(String[] args) {
        //采用匿名内部类
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println("在分支线程中："+i);
                }
            }
        });
        thread.start();

        for(int i=0;i<1000;i++) {
            System.out.println("在主线程中：" + i);
        }
    }
}