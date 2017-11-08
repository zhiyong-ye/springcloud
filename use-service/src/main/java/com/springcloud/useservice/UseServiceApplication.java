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
	 * @title: sayHelloWorld
	 * @Description:    helloworld测试
	 * @param: request
	 * @return: java.lang.String
	 * @date:   2017/11/8 17:40
	 */
	@RequestMapping(value = "/helloworld",method = RequestMethod.GET)
	public String sayHelloWorld(ServletRequest request) {
		return "hello world,i am " + request.getRemoteAddr() + ":" + port;
	}
}
