package com.ljj.jdk.reflect.generic;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liujinjian
 * @Date: 2020/9/10 21:28
 */
public class MyList<T> {
    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }


    public static void main(String[] args) {
        MyList<String> stringMyList = new MyList<>();
        stringMyList.add("刘金剑");
        TypeVariable<? extends Class<? extends MyList>>[] typeParameters = stringMyList.getClass().getTypeParameters();
        for (TypeVariable<? extends Class<? extends MyList>> typeParameter : typeParameters) {
            for (int i = 0; i < typeParameter.getBounds().length; i++) {
                System.out.println(typeParameter.getBounds()[i].getTypeName());
            }
            System.out.println(typeParameter.getTypeName());
        }
    }
}
