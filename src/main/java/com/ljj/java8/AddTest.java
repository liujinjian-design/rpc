package com.ljj.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liujinjian
 * @Date: 2020/8/31 10:20
 */
public class AddTest {

    public static void main(String[] args) {


        Add add = new Add();
        add.setAge(11);

        Add add1 = new Add();

        add1.setAge(12);

        List<Add> addList = new ArrayList<>();
        addList.add(add);
        addList.add(add1);

        int sum = addList.stream().collect(Collectors.summingInt(Add::getAge));
        System.out.println(sum);
    }
}
