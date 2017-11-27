package com.tr.p5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@EnableDiscoveryClient
//@EnableFeignClients
//@ServletComponentScan(value = { "com" })
@SpringBootApplication
@MapperScan("com.tr.p5.mapper")
public class ParentProject5Application {

	public static void main(String[] args) {
		SpringApplication.run(ParentProject5Application.class, args);
	}
}
