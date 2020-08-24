package test;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 16:51
 */
public class Test {

    public static void main(String[] args) {
        int i = (int) (3400 % 8);

        int j = (int) (3400 / 8 % 12);

        System.out.println(i);

        System.out.println(j);

        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));


        BigDecimal decimal = new BigDecimal("0.1");
        int m = (int) (decimal.floatValue() * 10.0f);
        System.out.println(m);

    }

}
