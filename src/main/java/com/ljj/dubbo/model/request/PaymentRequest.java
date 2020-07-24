package com.ljj.dubbo.model.request;

import java.io.Serializable;

/**
 * @Author: liujinjian
 * @Date: 2020/7/24 17:41
 */
public class PaymentRequest implements Serializable {

    private static final long serialVersionUID = 7814774238914574090L;

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
