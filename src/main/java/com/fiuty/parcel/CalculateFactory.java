package com.fiuty.parcel;

import com.fiuty.parcel.constants.ParcelCompanyEnum;
import com.fiuty.parcel.service.CalculateStrategy;
import com.fiuty.parcel.service.impl.CalculateStrategyJd;
import com.fiuty.parcel.service.impl.CalculateStrategySto;
import com.fiuty.parcel.service.impl.CalculateStrategyYto;
import com.fiuty.parcel.service.impl.CalculateStrategyZto;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类，负责创建针对不同快递公司计算不同邮费的类
 * @author Fiuty
 */
public class CalculateFactory {

    private Map<ParcelCompanyEnum, CalculateStrategy> map = new HashMap<>();

    {
        map.put(ParcelCompanyEnum.JD, new CalculateStrategyJd());
        map.put(ParcelCompanyEnum.YTO, new CalculateStrategyYto());
        map.put(ParcelCompanyEnum.ZTO, new CalculateStrategyZto());
        map.put(ParcelCompanyEnum.STO, new CalculateStrategySto());
    }

    public CalculateStrategy creat(ParcelCompanyEnum company) {
        return map.get(company);
    }
}
