package com.yuhb.springcloud.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-06-02
 */
@Configuration
public class SeataConfiguration {

    @Value("spring.application.name")
    private String applicationName;

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner(applicationName,"testcustomer-group");
    }
}
