package com.fiuty.thread;

import java.util.concurrent.*;

/**
 * 审核人：未审核
 *
 * @author 郑达悦
 */
public class CreatThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new FirstThred().start();
        new Thread(new SecondThread()).start();
        FutureTask<String> stringFutureTask = new FutureTask<>(new ThirdThread());
        new Thread(stringFutureTask).start();
        String returnValue = stringFutureTask.get();
        System.out.println("returnValue:" + returnValue);
        //从线程池获取
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println("创建线程的第四种方式,线程名："+Thread.currentThread().getName()));
        executorService.shutdown();
    }
}

class FirstThred extends Thread {
    /**
     * 继承Thread类重写run方法。
     */
    @Override
    public void run() {
        System.out.println("创建线程的第一种方式,线程名："+this.getName());
    }
}

class SecondThread implements Runnable {
    /**
     * 实现runnable接口，实现run方法。
     */
    @Override
    public void run() {
        System.out.println("创建线程的第二种方式,线程名："+Thread.currentThread().getName());
    }
}

class ThirdThread implements Callable<String> {
    /**
     * 实现Callable接口,实现call方法,带返回值的线程
     * @return 字符串
     */
    @Override
    public String call() {
        System.out.println("创建线程的第三种方式,线程名："+Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }
}

