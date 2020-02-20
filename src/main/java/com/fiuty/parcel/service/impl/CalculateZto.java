package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.Calculate;

/**
 * 计算中通邮费
 * @author Fiuty
 */
public class CalculateZto implements Calculate {

    @Override
    public Double calculate(Integer weight) {
        return 9 + weight * 1.1;
    }
}
