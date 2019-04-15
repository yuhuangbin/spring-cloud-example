package com.yuhb.springcloud.fallback;

import com.yuhb.springcloud.interfaces.EchoService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description: spring-cloud-customer -> spring-cloud-provider fallbackFactory catch Exceptoin
 * author: yu.hb
 * Date: 2019-04-15
 */
@Component
public class CustomerHyStrixFallBack implements FallbackFactory<EchoService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHyStrixFallBack.class);

    @Override
    public EchoService create(Throwable throwable) {
        Exception exception = (Exception) throwable;
        return new EchoService() {
            @Override
            public String echo(String name) {
                LOGGER.error("excute EchoService.echo() error ", exception);
                return String.format("spring-cloud-customer -> spring-cloud-provider fallback , request params : %s", name);
            }

        };
    }

}
