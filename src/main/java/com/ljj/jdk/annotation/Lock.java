package com.ljj.jdk.annotation;

import java.lang.annotation.*;

/**
 * @Author: liujinjian
 * @Date: 2020/8/12 18:01
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Lock {

    String name();
}
