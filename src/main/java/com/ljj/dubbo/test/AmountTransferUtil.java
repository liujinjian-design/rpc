package com.ljj.dubbo.test;

import java.math.BigDecimal;

/**
 * @Author: liujinjian
 * @Date: 2020/7/30 10:44
 */
public class AmountTransferUtil {

    /**
     * 元转分
     *
     * @param yuan
     * @return
     */
    public static int transferYuanToFen(BigDecimal yuan) {
        return yuan.multiply(new BigDecimal("100")).intValue();
    }
}
