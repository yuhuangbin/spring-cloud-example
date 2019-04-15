package com.yuhb.springcloud.provider;

import com.yuhb.springcloud.interfaces.EchoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String name) {
//        int a = 1/0; // 制造异常测试
        return "provider result : " + name;
    }
}
