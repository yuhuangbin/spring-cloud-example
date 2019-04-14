package com.yuhb.springcloud.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-cloud-provider")
public interface EchoService {

    @RequestMapping("/echo")
    public String echo(@RequestParam("name") String name);
}
