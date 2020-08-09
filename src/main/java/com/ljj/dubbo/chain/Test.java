package com.ljj.dubbo.chain;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liujinjian
 * @Date: 2020/8/2 19:39
 */
public class Test {

    public static void main(String[] args) {
        List<MyFilter> list = new ArrayList<>();
        list.add(new ExcetpionFilter());
        list.add(new TimeoutFilter());
        MyInvoker myInvoker = new MyInvoker() {
            @Override
            public Class getInterface() {
                return null;
            }

            @Override
            public Result invoke(Invocation invocation) throws RpcException {
                return null;
            }

            @Override
            public URL getUrl() {
                return null;
            }

            @Override
            public boolean isAvailable() {
                return false;
            }

            @Override
            public void destroy() {

            }
        };
        for (MyFilter filter : list) {
            MyInvoker finalMyInvoker = myInvoker;
            myInvoker = new MyInvoker() {
                @Override
                public URL getUrl() {
                    return null;
                }

                @Override
                public boolean isAvailable() {
                    return false;
                }

                @Override
                public void destroy() {

                }

                @Override
                public Class getInterface() {
                    return null;
                }

                @Override
                public Result invoke(Invocation invocation) throws RpcException {
                    return filter.invoke(finalMyInvoker, invocation);
                }
            };
        }

        Field[] fields = myInvoker.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println(myInvoker.invoke(null));

    }
}
