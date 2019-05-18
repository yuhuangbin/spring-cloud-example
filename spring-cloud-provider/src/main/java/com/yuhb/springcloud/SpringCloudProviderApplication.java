package com.yuhb.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.yuhb.springcloud.mapper")
public class SpringCloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProviderApplication.class, args);
	}

}
