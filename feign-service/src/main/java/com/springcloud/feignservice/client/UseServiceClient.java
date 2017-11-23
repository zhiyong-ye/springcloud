package com.springcloud.feignservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @package: com.springcloud.feignservice.client
 * @Description: feign客户端接口定义，用于调用use-service服务
 * @author: zhiyong-ye
 * @email: 773276516@qq.com
 * @date: 2017/11/23 14:04
 * @version: V1.0
 * @Copyright: 2017 All rights Reserved, Designed By zhiyong-ye.
 */
@FeignClient("use-service")
public interface UseServiceClient {

    @GetMapping("/sayHello")
    String sayHello(@RequestParam(value = "name") String name);
}
