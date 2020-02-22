package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.CalculateStrategy;

/**
 * 计算中通邮费
 * @author Fiuty
 */
public class ZtoCalculateStrategy implements CalculateStrategy {

    @Override
    public Double calculate(Integer weight) {
        return 9 + weight * 1.1;
    }
}
