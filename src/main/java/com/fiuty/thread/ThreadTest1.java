package com.fiuty.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 审核人：未审核
 *
 * @author 郑达悦
 */
public class ThreadTest1 extends Thread{

    private static final Logger log = LoggerFactory.getLogger(ThreadTest1.class);

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("e:{}", e);
            }
            System.out.println(ThreadTest1.class.getName());
        }
    }

}
