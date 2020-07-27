package com.ljj.dubbo.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 15:40
 */
public class Test {

    public static void main(String[] args) {
        ExtensionLoader<UserService> extensionLoader = ExtensionLoader.getExtensionLoader(UserService.class);
        UserService userService = extensionLoader.getExtension("userServiceImpl");
        System.out.println(userService.queryOrder("11", 100L));

    }
}
