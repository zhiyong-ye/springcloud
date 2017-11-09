package com.springcloud.ribbonservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @package: com.springcloud.ribbonservice.service
 * @Description: 测试ribbon消费者调用服务service层
 * @author: zhiyong-ye
 * @email: 773276516@qq.com
 * @date: 2017/11/9 16:23
 * @version: V1.0
 * @Copyright: 2017 All rights Reserved, Designed By zhiyong-ye.
 */
@Service
public class HelloService {

    /**
     * 注入restTemplate
     */
    @Autowired
    private RestTemplate restTemplate;
    
    public String sayHello(String name) {
        String resultStr = restTemplate.getForObject("http://USE-SERVICE/sayHello?name=" + name, String.class);
        return  "result:" + resultStr;
    }
}
