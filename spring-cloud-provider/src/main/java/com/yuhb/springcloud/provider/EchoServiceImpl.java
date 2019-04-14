package com.yuhb.springcloud.provider;

import com.yuhb.springcloud.interfaces.EchoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String name) {
        System.out.println(name);
        return "provider result : " + name;
    }
}
