package com.fiuty.javaBasis;

import com.fiuty.domain.Coupon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fiuty
 */
public class BasisMain {

    public static void main(String[] args) {
        List<Coupon> coupons = couponList();
        System.out.println("cumulative1:" + cumulative1(coupons));
        System.out.println("cumulative2:" + cumulative2(coupons));
        System.out.println("cumulativeByLambda:" + cumulativeByLambda(coupons));
    }

    private static List<Coupon> couponList() {
        Coupon coupon1 = new Coupon("店铺优惠券", new BigDecimal("100"));
        Coupon coupon2 = new Coupon("商品优惠券", new BigDecimal("50"));
        Coupon coupon3 = new Coupon("店铺优惠券", new BigDecimal("100"));
        Coupon coupon4 = new Coupon("满减优惠券", new BigDecimal("35"));
        List<Coupon> couponList = new ArrayList<>(4);
        couponList.add(coupon1);
        couponList.add(coupon2);
        couponList.add(coupon3);
        couponList.add(coupon4);
        return couponList;
    }

    private static Map<String, BigDecimal> cumulativeByLambda(List<Coupon> coupons) {
        //key name,value cumulative price
        Map<String, BigDecimal> couponMap = new HashMap<>(5);
        coupons.forEach(coupon -> {
            String nameKey = coupon.getName();
            BigDecimal amountValue = coupon.getAmount();
            couponMap.merge(nameKey, amountValue, BigDecimal::add);
        });
        return couponMap;
    }

    private static Map<String, BigDecimal> cumulative1(List<Coupon> coupons) {
        //key name,value cumulative price
        Map<String, BigDecimal> couponMap = new HashMap<>(5);
        coupons.forEach(coupon -> {
            String nameKey = coupon.getName();
            BigDecimal amountValue = coupon.getAmount();
            if (couponMap.containsKey(nameKey)) {
                couponMap.put(nameKey, couponMap.get(nameKey).add(amountValue));
            } else {
                couponMap.put(nameKey, amountValue);
            }
        });
        return couponMap;
    }

    private static Map<String, BigDecimal> cumulative2(List<Coupon> coupons) {
        //key name,value cumulative price
        Map<String, BigDecimal> couponMap = new HashMap<>(5);
        coupons.forEach(coupon -> {
            String nameKey = coupon.getName();
            BigDecimal amountValue = coupon.getAmount();
            couponMap.put(nameKey, couponMap.get(nameKey) == null ? amountValue : couponMap.get(nameKey).add(amountValue));
        });
        return couponMap;
    }
}
