package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.Calculate;

/**
 * 计算圆通邮费
 * @author Fiuty
 */
public class CalculateYto implements Calculate {
    @Override
    public Double calculate(Integer weight) {
        return 8 + weight * 1.5;
    }
}
