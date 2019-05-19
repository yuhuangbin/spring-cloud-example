package com.yuhb.springcloud;

import com.yuhb.springcloud.bindings.ProviderBindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-05-19
 */
@SpringBootApplication
@EnableBinding(value = ProviderBindings.class)
@RestController
public class RabbitMqProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProviderApp.class,args);
    }

    @Autowired
    private ProviderBindings providerBindings;

    @RequestMapping(value = "/send")
    public void send(String data) {
        providerBindings.output1().send(MessageBuilder.withPayload(data).build());
    }


}
