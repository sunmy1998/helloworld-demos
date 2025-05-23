package com.swy.service;


import com.swy.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author: SMY
 * @time: 2025/5/24  00:48
 * @description: DemoServiceImpl
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
