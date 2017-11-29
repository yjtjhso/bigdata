/**
 * Created by Administrator on 2017/11/16.
 */
public class Test implements Runnable {

    private int num;
    private Object lock;
    private int count=0;

    public Test(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        try {
            while(true){
                synchronized(lock){
                    lock.notifyAll();
                    lock.wait();
                    System.out.println("thread:"+Thread.currentThread().getId()+"==="+num+"------"+(count++));
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        final Object lock = new Object();

        Thread thread1 = new Thread(new Test(1,lock));
        Thread thread2 = new Thread(new Test(2, lock));

        thread1.start();
        thread2.start();
    }

}