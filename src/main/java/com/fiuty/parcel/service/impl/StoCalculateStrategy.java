package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.CalculateStrategy;

/**
 * 计算申通邮费
 * @author Fiuty
 */
public class StoCalculateStrategy implements CalculateStrategy {
    @Override
    public Double calculate(Integer weight) {
        return 12 + weight * 0.8;
    }
}
