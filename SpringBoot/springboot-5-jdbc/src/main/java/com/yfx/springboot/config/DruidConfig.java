package com.yfx.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//@Configuration  此注解表示这是一个配置类：
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){

        return new DruidDataSource();
    }

    //配置后台管理 Servlet  实现类：com.alibaba.druid.support.http.StatViewServlet  extends ResourceServlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*"); //处理druid下的所有请求
        //w为Serlvet 设置初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername","root");
        initParams.put("loginPassword","123");
        initParams.put("allow",""); //默认允许所有访问
        initParams.put("deny","192.168.64.22");
        bean.setInitParameters(initParams);
        return bean;
    }

    //配置Web  Filter  实现类：com.alibaba.druid.support.http.WebStatFilter
    @Bean
    public FilterRegistrationBean  webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //配置初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.css, *.js, /druid/*");  //释放静态资源
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
