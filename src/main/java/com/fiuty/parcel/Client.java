package com.fiuty.parcel;

import com.fiuty.parcel.constants.ParcelCompanyEnum;

/**
 * 客户端
 * @author Fiuty
 */
public class Client {

    public static void main(String[] args) {
        ParcelCompanyEnum company = ParcelCompanyEnum.JD;
        Integer weight = 15;
        CalculatePostage calculatePostage = new CalculatePostage();

        System.out.println("if else 计算邮费：" + calculatePostage.calculatePostage1(company, weight));

        System.out.println("switch case 计算邮费：" + calculatePostage.calculatePostage2(company, weight));

        System.out.println("传统工厂模式 + 策略模式 计算邮费：" + calculatePostage.calculatePostage3(company, weight));

        System.out.println("Java8 lambda + 策略模式 计算邮费：" + calculatePostage.map.get(company).apply(weight));

    }
}
