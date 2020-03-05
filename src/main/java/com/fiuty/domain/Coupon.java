package com.fiuty.domain;

import java.math.BigDecimal;

/**
 * 优惠券
 * @author Fiuty
 */
public class Coupon {
    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 优惠券金额
     */
    private BigDecimal amount;

    @Override
    public String toString() {
        return "Coupon{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Coupon(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
