package com.fiuty.thread;


/**
 * 审核人：未审核
 *
 * @author 郑达悦
 */
public class Main {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //testRunAndStart();
        //testSleep();
        //testYield();
        //testJion();
        //testAdd();
        //testAddNoSync();
        testM1M2();
    }

    private static void testRunAndStart() {
        ThreadTest1 threadTest1 = new ThreadTest1();
        //threadTest1.run();通过run方法启动线程其实就是调用一个类中的方法，当作普通的方法的方式调用。并没有创建一个线程，
        //程序中依旧只有一个主线程，必须等到run()方法里面的代码执行完毕，才会继续执行下面的代码，这样就没有达到写线程的目的。
        //start会开启一个新的线程,达到真正的多线程的效果,启动线程后执行run方法的逻辑。
        threadTest1.start();
        for(int i=0; i<10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Main.class.getName());
        }
    }

    private static void testSleep() {
        //Sleep,意思就是睡眠，当前线程暂停一段时间让给别的线程去运行。Sleep是怎么复活的？由你的睡眠时间而定，等睡眠到规定的时间自动复活
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sleep(10);
                System.out.println("testSleep:" + i);
            }
        }).start();
    }

    private static void testYield() {
        //yield是当前线程让出cpu,进入等待队列（就绪态）,但是需要根据当前系统的调度算法,有可能还会继续执行（进程被调度）。
        //从runing状态转到ready状态。
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("testYield A:" + i);
                if (i % 2 == 0) {
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("testYield B:"+i);
                if (i % 2 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    private static void testJion() {
        //join是当前线程调用其他线程,本线程等待,等调用的线程运行完毕,本线程再继续执行下去。
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("testJion T1:" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            join(t1);
            for (int i = 0; i < 10; i++) {
                System.out.println("testJion T2:" + i);
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void testAdd() throws InterruptedException {
        ThreadTest2 t2 = new ThreadTest2();
        t2.startThread();
    }

    private static void testAddNoSync() throws InterruptedException {
        ThreadTest2 t2 = new ThreadTest2();
        t2.startThreadNoSync();
    }

    private static void testM1M2() {
        ThreadTest2 t2 = new ThreadTest2();
        t2.testM1M2();
    }
}
