package com.fiuty.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 直接插入排序
 * @author Fiuty
 */
public class DirectInsertSort {

    private static final Logger log = LoggerFactory.getLogger(DirectInsertSort.class);

    public static int[] sort1(int[] arrays) {
        //第一层循环从第二个元素开始，设定第一个元素为有序。
        for (int index = 1; index < arrays.length; index++) {
            //如果待排序数值小于排序后最后一个值，则需要排序
            if (arrays[index] < arrays[index - 1]) {
                int temp = arrays[index];
                int sortedIndex;
                for (sortedIndex = index - 1; sortedIndex >= 0; sortedIndex--) {
                    if (arrays[sortedIndex] > temp) {
                        arrays[sortedIndex + 1] = arrays[sortedIndex];
                    } else {
                        break;
                    }
                }
                arrays[sortedIndex + 1] = temp;
            }
            log.info("sort1:{}", arrays);
        }
        return arrays;
    }

    public static int[] sort2(int[] arrays) {
        //第一层循环从第二个元素开始，设定第一个元素为有序。
        for (int index = 1; index < arrays.length; index++) {
            //如果待排序数值小于排序后最后一个值，则需要排序
            if (arrays[index] < arrays[index - 1]) {
                int temp = arrays[index];
                int sortedIndex;
                for (sortedIndex = index - 1; sortedIndex >= 0 && arrays[sortedIndex] > temp; sortedIndex--) {
                    arrays[sortedIndex + 1] = arrays[sortedIndex];
                }
                arrays[sortedIndex + 1] = temp;
            }
        }
        return arrays;
    }
}
