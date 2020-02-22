package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.CalculateStrategy;

/**
 * 计算圆通邮费
 * @author Fiuty
 */
public class YtoCalculateStrategy implements CalculateStrategy {
    @Override
    public Double calculate(Integer weight) {
        return 8 + weight * 1.5;
    }
}
