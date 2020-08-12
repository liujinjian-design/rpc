package com.ljj.jdk.annotation;

/**
 * @Author: liujinjian
 * @Date: 2020/8/12 18:07
 */
@Lock(name = "MyLock")
public class AnnotationTest {


    public void test() {
        System.out.println("MyLock");
    }




}
