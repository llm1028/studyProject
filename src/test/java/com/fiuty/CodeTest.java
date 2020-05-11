package com.fiuty;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PublicKey;
import java.util.Scanner;

/**
 * 审核人：未审核
 *
 * @author 郑达悦
 */
public class CodeTest {

    private static final Logger log = LoggerFactory.getLogger(CodeTest.class);

    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int lastBlankIndex = str.lastIndexOf(" ");
        int lastWordLength = str.length() - lastBlankIndex - 1;
        System.out.println(lastWordLength);
    }

    @Test
    public void test1() {
        String str = "ABSIB T";
        int i = str.lastIndexOf(" ");
        log.debug("最后一个空格i:{}", i);
        int lastWordLength = str.length() - i - 1;
        log.debug("lastWordLength:{}", lastWordLength);
    }
}
