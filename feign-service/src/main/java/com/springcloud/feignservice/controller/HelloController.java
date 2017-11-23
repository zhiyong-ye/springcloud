package com.springcloud.feignservice.controller;

import com.springcloud.feignservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.springcloud.feignservice.controller
 * @Description: 测试feign消费者调用服务controller
 * @author: zhiyong-ye
 * @email: 773276516@qq.com
 * @date: 2017/11/23 14:13
 * @version: V1.0
 * @Copyright: 2017 All rights Reserved, Designed By zhiyong-ye.
 */
@RestController
public class HelloController {

    /**
     * 注入helloService
     */
    @Autowired
    private HelloService helloService;

    @GetMapping("/sayHello")
    public Object sayHello(String name) {
    	return helloService.sayHello(name);
    }
}
