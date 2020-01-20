package com.fiuty.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 审核人：未审核
 *
 * @author 郑达悦
 */
public class ReadFile {

    private static final Logger log = LoggerFactory.getLogger(ReadFile.class);

    /**
     * 解析txt文件的内容,在控制台输出txt每一行的内容
     *
     * @param pathName txt文件的路径
     */
    public static void readTxtFile(String pathName) {
        try {
            //指定编码格式,utf-8/gbk,pc默认是gbk
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathName), "GBK"));
            String line;
            while ((line = br.readLine()) != null) {
                log.debug("txt每一行的内容:{}", line);
            }
        } catch (Exception e) {
            log.error("异常信息如下：{}", e);
        }
    }
}
