package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.CalculateStrategy;

/**
 * 计算京东邮费
 * @author Fiuty
 */
public class JdCalculateStrategy implements CalculateStrategy {

    @Override
    public Double calculate(Integer weight) {
        return 10 + weight * 1.2;
    }
}
