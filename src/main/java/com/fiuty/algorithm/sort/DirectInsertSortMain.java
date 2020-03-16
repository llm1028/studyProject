package com.fiuty.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fiuty
 */
public class DirectInsertSortMain {
    private static final Logger log = LoggerFactory.getLogger(DirectInsertSortMain.class);
    public static void main(String[] args) {
        int[] array = {4, 3, 7, 8, 5, 11, 56, 100, 85};
        //DirectInsertSort.sort1(array);
        log.info("array:{}", array);
        DirectInsertSort.sort2(array);
        log.info("array:{}", array);
    }
}
