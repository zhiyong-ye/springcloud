package com.springcloud.useservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * EnableEurekaClient	EurekaClient服务提供者
 */
@EnableEurekaClient
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
	 * @date:   2017/11/9 16:45
	 */
	@RequestMapping(value = "/sayHello",method = RequestMethod.GET)
	public String sayHello(String name) {
		return "hello," + name + ",i am from port:" + port;
	}
}
