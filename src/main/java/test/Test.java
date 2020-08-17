package test;

import java.util.UUID;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 16:51
 */
public class Test {

    public static void main(String[] args) {
        int i = (int) (920081718790003542L % 8);

        int j = (int) (920081718790003542L / 8 % 4);

        System.out.println(i);

        System.out.println(j);

        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));

    }

}
