package test;

import java.util.UUID;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 16:51
 */
public class Test {

    public static void main(String[] args) {
        int i = (int) (100635127 % 8);

        int j = (int) (100635127 / 8 % 64);

        System.out.println(i);

        System.out.println(j);

        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));

    }

}
