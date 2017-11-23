package com.springcloud.useservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableDiscoveryClient   开启服务客户端功能，在这里用作服务提供者，在服务注册中心注册，供其他服务调用
 * @EnableDiscoveryClient注解(eureka，consul，zookeeper治理体系通用)
 * @EnableEurekaClient注解只适用于eureka治理体系服务
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class UseServiceApplication {

	/**
	 * 请求端口
	 */
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(UseServiceApplication.class, args);
	}

    /*
     * @title: sayHello
     * @Description:    seyHello测试
     * @param: name
     * @return: java.lang.String
     * @date:   2017/11/23 14:41
     */
    @GetMapping("/sayHello")
	public String sayHello(String name) {
		return "hello," + name + ",i am from port:" + port;
	}
}
