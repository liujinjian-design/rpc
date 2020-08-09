package com.ljj.dubbo.chain;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @Author: liujinjian
 * @Date: 2020/8/2 19:33
 */
public interface MyFilter {

    Result invoke(MyInvoker<?> invoker, Invocation invocation) throws RpcException;
}
