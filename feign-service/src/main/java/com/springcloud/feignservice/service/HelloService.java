package com.springcloud.feignservice.service;

import com.springcloud.feignservice.client.UseServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.springcloud.feignservice.service
 * @Description: TODO(please write your description)
 * @author: zhiyong-ye
 * @email: 773276516@qq.com
 * @date: 2017/11/23 14:19
 * @version: V1.0
 * @Copyright: 2017 All rights Reserved, Designed By zhiyong-ye.
 */
@Service
public class HelloService {

    /**
     * 注入useServiceClient，用于调用use-service服务
     */
    @Autowired
    private UseServiceClient useServiceClient;
    
    /*
     * @title: sayHello
     * @Description:    sayHello demo service feign方式调用
     * @param: name
     * @return: java.lang.String
     * @date:   2017/11/23 14:24
     */	
    public String sayHello(String name) {
    	return useServiceClient.sayHello(name);
    }
}
