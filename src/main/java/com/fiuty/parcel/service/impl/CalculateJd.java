package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.Calculate;

/**
 * 计算京东邮费
 * @author Fiuty
 */
public class CalculateJd implements Calculate {

    @Override
    public Double calculate(Integer weight) {
        return 10 + weight * 1.2;
    }
}
