package com.yfx.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {       //这是一个消费类

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/web")
    public String toClient(){
        /**
         想要调用springcolud-service-provider的工程模块，
         就要在配置文件中定义一个RestTemplate 这样的类，如下就是使用方式！

         * 但此种方式就是手动的去指定一个访问地址，若要有多个或者中途模块更换，这样的效率是低的！
         */

        //.getBody(); 返回一个字符串
       // return  restTemplate.getForEntity("http://localhost:8080/service", String.class).getBody();

        //当拥有了服务名称就不需要上面的return ， SPRINGCLOUD-SERVICE-PROVIDER  就是服务的名称， 这时就不需要知道iP 和端口号了！
        return  restTemplate.getForEntity("http://SPRINGCLOUD-SERVICE-PROVIDER/service", String.class).getBody();
    }
}
