package com.ljj.dubbo.service.impl;

import com.ljj.dubbo.model.request.PaymentRequest;
import com.ljj.dubbo.model.response.PaymentResponse;
import com.ljj.dubbo.service.PaymentService;

/**
 * @Author: liujinjian
 * @Date: 2020/7/24 17:49
 */
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponse doPayment(PaymentRequest paymentRequest) {
        System.out.println("接受到请求");
        return null;
    }
}
