package com.yuhb.springcloud.interfaces;

import com.yuhb.springcloud.domain.SysUser;
import com.yuhb.springcloud.fallback.CustomerHyStrixFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-cloud-provider", fallbackFactory = CustomerHyStrixFallBack.class)
public interface EchoService {

    @RequestMapping("/echo")
    public SysUser echo(@RequestParam("id") Integer id);
}
