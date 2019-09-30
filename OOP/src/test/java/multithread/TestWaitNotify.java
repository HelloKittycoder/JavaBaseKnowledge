package multithread;

/**
 * Created by shucheng on 2019-9-29 下午 23:36
 * wait、notify的执行顺序
 *
 * 打印结果：
 * Thread 2 sent notify.
 * Thread 1 wake up.
 *
 * 代码说明：
 * 线程t1，t2启动
 * t1先获得锁，然后执行wait方法后，处于等待状态，并释放锁；
 * t2获得锁后，执行notifyAll方法，通知t1线程，但是不释放锁，接着打印“Thread 2 sent notify.”，代码执行后，直接释放锁；
 * 此时t1获得锁，继续执行wait方法后的代码，打印“Thread 1 wake up.”
 */
public class TestWaitNotify {

    public static void main(String[] args) throws Exception {
        // 这种写法有什么问题？
        // wait、notify都是要在事先有锁的情况下，也就是需要在synchronized代码块里，才能使用
        // https://www.cnblogs.com/hapjin/p/5492645.html
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(this);
                    System.out.println("代码被阻塞");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
                System.out.println("代码被释放");
                this.notify();
            }
        }).start();*/

        final Object obj = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        obj.wait();
                        System.out.println("Thread 1 wake up.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    obj.notifyAll();
                    System.out.println("Thread 2 sent notify.");
                }
            }
        };
        t2.start();
    }
}
