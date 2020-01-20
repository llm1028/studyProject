package com.fiuty.pattern;

import com.fiuty.constant.ProductEnum;
import com.fiuty.domain.AbstractFinanceProduct;
import com.fiuty.domain.BondFinanceProduct;
import com.fiuty.domain.LoanFinanceProduct;
import com.fiuty.domain.StockFinanceProduct;

/**
 * 简单工厂类
 *
 * @author 郑达悦
 */
public class SimpleFactory {

    public static AbstractFinanceProduct creatProduct(ProductEnum productEnum) {
        switch (productEnum) {
            case Bond :
                return new BondFinanceProduct();
            case Loan :
                return new LoanFinanceProduct();
            case Stock :
                return new StockFinanceProduct();
            default:
                throw new RuntimeException("No such product" + productEnum.name());
        }
    }
}
