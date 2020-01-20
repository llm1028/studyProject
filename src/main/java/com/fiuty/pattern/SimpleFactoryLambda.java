package com.fiuty.pattern;

import com.fiuty.constant.ProductEnum;
import com.fiuty.domain.AbstractFinanceProduct;
import com.fiuty.domain.BondFinanceProduct;
import com.fiuty.domain.LoanFinanceProduct;
import com.fiuty.domain.StockFinanceProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 用lambda的方式实现简单工厂模式
 * @author 郑达悦
 */
public class SimpleFactoryLambda {
    private final static Map<ProductEnum, Supplier<AbstractFinanceProduct>> PRODEUC_MAP = new HashMap<>();
    static {
        PRODEUC_MAP.put(ProductEnum.Bond, BondFinanceProduct::new);
        PRODEUC_MAP.put(ProductEnum.Stock, StockFinanceProduct::new);
        PRODEUC_MAP.put(ProductEnum.Loan, LoanFinanceProduct::new);
    }

    public static AbstractFinanceProduct creatProduct(ProductEnum productEnum) {
        Supplier<AbstractFinanceProduct> productSupplier = PRODEUC_MAP.get(productEnum);
        if (productSupplier != null) {
            return productSupplier.get();
        }
        throw new IllegalArgumentException("No such product" + productEnum.name());
    }
}
