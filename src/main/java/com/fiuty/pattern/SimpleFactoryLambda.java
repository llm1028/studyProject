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
class SimpleFactoryLambda {
    /**
     * Map的value是一个函数式接口,里面的接口待实现
     */
    private final static Map<ProductEnum, Supplier<AbstractFinanceProduct>> PRODEUC_MAP = new HashMap<>();
    static {
        //这里put进去的value就是函数式接口的一个实现,lambda表达式的方法引用
        PRODEUC_MAP.put(ProductEnum.Bond, BondFinanceProduct::new);
        PRODEUC_MAP.put(ProductEnum.Stock, StockFinanceProduct::new);
        PRODEUC_MAP.put(ProductEnum.Loan, LoanFinanceProduct::new);
    }

    static AbstractFinanceProduct creatProduct(ProductEnum productEnum) {
        Supplier<AbstractFinanceProduct> productSupplier = PRODEUC_MAP.get(productEnum);
        if (productSupplier != null) {
            //这里每次调用都生成新的对象,map的value得到的是一个函数式接口的lambda实现,每次都new新对象出来。
            return productSupplier.get();
        }
        throw new IllegalArgumentException("No such product" + productEnum.name());
    }
}
