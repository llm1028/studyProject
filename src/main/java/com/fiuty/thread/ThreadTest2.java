package com.fiuty.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 审核人：未审核
 *
 * @author 郑达悦
 */
public class ThreadTest2 {

    private int count = 0;

    public void add() {
        synchronized (this) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count++;
        }
    }

    public void addNoSync() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        count++;
    }

    public void startThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                add();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("count:" + count);
    }

    public void startThreadNoSync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                addNoSync();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("count:" + count);
    }

    public void m1() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+",m1 start..");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+",m1 end..");
        }
    }

    public void m2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+",m2 start..");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+",m2 end..");
    }

    public void testM1M2() {
        //是串行的,会等待加同步方法关键字的方法执行完毕再执行后续的流程。
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    m1();
                    m2();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
