package com.ljj.dubbo.service;

import com.ljj.dubbo.model.request.PaymentRequest;
import com.ljj.dubbo.model.response.PaymentResponse;

/**
 * @Author: liujinjian
 * @Date: 2020/7/24 17:43
 */
public interface PaymentService {

    PaymentResponse doPayment(PaymentRequest paymentRequest);

}
