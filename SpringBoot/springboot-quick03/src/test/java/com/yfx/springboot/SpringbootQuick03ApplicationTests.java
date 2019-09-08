package com.yfx.springboot;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuick03ApplicationTests {

    //记录器
    Logger logger = LogManager.getLogger(getClass());
    @Test
    public void contextLoads() {

        //日志级别   由低到高 trance < debug < info < warn < error
        logger.trace("trace.....");
        logger.debug("debug.....");
        //springboot 默认输出info 级别以上的！
        logger.info("info.....");
        logger.warn("warn.....");
        logger.error("error......");


    }

}
