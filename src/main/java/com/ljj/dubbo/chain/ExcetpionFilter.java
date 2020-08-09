package com.ljj.dubbo.chain;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @Author: liujinjian
 * @Date: 2020/8/2 19:38
 */
public class ExcetpionFilter implements MyFilter {
    @Override
    public Result invoke(MyInvoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("ExceptionFilter");
        return invoker.invoke(invocation);
    }
}
