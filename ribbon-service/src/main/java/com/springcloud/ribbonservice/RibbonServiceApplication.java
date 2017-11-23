package com.springcloud.ribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient   开启服务客户端功能，在这里用作服务消费者，在服务注册中心注册，调用其他服务
 * @EnableDiscoveryClient注解(eureka，consul，zookeeper治理体系通用)
 * @EnableEurekaClient注解只适用于eureka治理体系服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
