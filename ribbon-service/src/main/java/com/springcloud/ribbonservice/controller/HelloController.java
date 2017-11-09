package com.springcloud.ribbonservice.controller;

import com.springcloud.ribbonservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.springcloud.ribbonservice.controller
 * @Description: 测试ribbon消费者调用服务controller层
 * @author: zhiyong-ye
 * @email: 773276516@qq.com
 * @date: 2017/11/9 16:21
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

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public Object sayHello(String name) {
        //调用service
    	return helloService.sayHello(name);
    }
}
