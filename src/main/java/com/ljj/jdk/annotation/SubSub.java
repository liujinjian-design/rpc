package com.ljj.jdk.annotation;

/**
 * @Author: liujinjian
 * @Date: 2020/8/12 18:31
 */
public class SubSub extends Sub {

    public static void main(String[] args) {
        Lock annotation = SubSub.class.getAnnotation(Lock.class);
        System.out.println(annotation.name());
    }
}
