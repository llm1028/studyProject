package com.fiuty.pattern.chain;

/**
 * 短文检查拼写处理器
 * @author Fiuty
 */
public class CheckSpellHandler extends Handler{
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
