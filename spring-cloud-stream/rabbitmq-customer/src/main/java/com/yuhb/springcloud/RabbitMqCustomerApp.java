package com.yuhb.springcloud;

import com.yuhb.springcloud.binder.CustomerSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-05-19
 */
@SpringBootApplication
@EnableBinding(value = CustomerSink.class)
public class RabbitMqCustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqCustomerApp.class,args);
    }

    @StreamListener(CustomerSink.CUS_INPT_1)
    public void receive(String data) {
        System.out.println("customer receive :" + data);
    }


}
