package com.fiuty.parcel;

import com.fiuty.parcel.constants.ParcelCompanyEnum;
import com.fiuty.parcel.service.Calculate;
import com.fiuty.parcel.service.impl.CalculateJd;
import com.fiuty.parcel.service.impl.CalculateSto;
import com.fiuty.parcel.service.impl.CalculateYto;
import com.fiuty.parcel.service.impl.CalculateZto;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类，负责创建针对不同快递公司计算不同邮费的类
 * @author Fiuty
 */
public class CalculateFactory {

    private Map<ParcelCompanyEnum, Calculate> map = new HashMap<>();

    {
        map.put(ParcelCompanyEnum.JD, new CalculateJd());
        map.put(ParcelCompanyEnum.YTO, new CalculateYto());
        map.put(ParcelCompanyEnum.ZTO, new CalculateZto());
        map.put(ParcelCompanyEnum.STO, new CalculateSto());
    }

    public Calculate creat(ParcelCompanyEnum company) {
        return map.get(company);
    }
}
