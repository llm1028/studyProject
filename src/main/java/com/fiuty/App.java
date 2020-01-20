package com.fiuty;

import com.fiuty.util.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.debug("hello {}", "debug日志");
        ReadFile.readTxtFile("C:\\Users\\daoben-pc\\Desktop\\input.txt");
    }
}
