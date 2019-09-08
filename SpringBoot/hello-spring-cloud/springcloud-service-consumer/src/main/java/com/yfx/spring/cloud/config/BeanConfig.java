package com.yfx.spring.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration      //这是一个配置类  等价于 spring 中的 *.xml
public class BeanConfig {

    /**
     * @Bean
     * 等价于
     *          <bean id="restTemplate" class="***.RestTemplate"></bean>
     * @return
     */
    @LoadBalanced       //Ribbon  的负载均衡注解
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

}
