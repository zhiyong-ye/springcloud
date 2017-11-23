package com.springcloud.feignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @EnableDiscoveryClient   开启服务客户端功能，在这里用作服务提供者，在服务注册中心注册，供其他服务调用
 * @EnableDiscoveryClient注解(eureka，consul，zookeeper治理体系通用)
 * @EnableEurekaClient注解只适用于eureka治理体系服务
 * @EnableFeignClients注解开启feign功能
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignServiceApplication.class, args);
	}
}
