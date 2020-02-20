package com.fiuty.parcel.service.impl;

import com.fiuty.parcel.service.Calculate;

/**
 * 计算申通邮费
 * @author Fiuty
 */
public class CalculateSto  implements Calculate {
    @Override
    public Double calculate(Integer weight) {
        return 12 + weight * 0.8;
    }
}
