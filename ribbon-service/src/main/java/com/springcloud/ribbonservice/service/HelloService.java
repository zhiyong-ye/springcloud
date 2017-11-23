package com.springcloud.ribbonservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    /**
     * 注入loadBalancerClient，用于负载均衡获取服务实例信息
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    /*
     * @title: sayHello
     * @Description:    sayHello demo service
     * @param: name
	 * @param: isRibbon
     * @return: java.lang.String
     * @date:   2017/11/23 11:11
     */
    public String sayHello(String name,boolean isRibbon) {
        String invokeMethodName = "sayHello";
        String paramStr = "?name=" + name;
        String url = "";

        if (isRibbon == true) {
            //ribbon模式调用（使用服务名称调用服务）
            url = "http://USE-SERVICE/" + invokeMethodName + paramStr;
        }else {
            //负载均衡选择服务实例
            ServiceInstance serviceInstance = loadBalancerClient.choose("USE-SERVICE");
            //使用基础模式调用（使用ip地址跟端口调用服务）
            url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + invokeMethodName + paramStr;
        }

        System.out.println(url);
        //调用服务
        String resultStr = restTemplate.getForObject(url, String.class);

        return  resultStr;
    }
}