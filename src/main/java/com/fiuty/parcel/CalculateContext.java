package com.fiuty.parcel;

import com.fiuty.parcel.service.CalculateStrategy;

/**
 * 中间类
 * @author Fiuty
 */
public class CalculateContext {

    private CalculateStrategy calculateStrategy;

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public Double calculate(Integer weigth) {
        return calculateStrategy.calculate(weigth);
    }

}
