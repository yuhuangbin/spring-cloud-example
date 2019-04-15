package com.yuhb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients
public class SpringCloudCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCustomerApplication.class, args);
	}

}
