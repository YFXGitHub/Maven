package com.yfx.springboot;


import com.yfx.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuick024ApplicationTests {
    /*
        若@RunWith 和 @Test 引入不了jar包，
        执行File --> Project Structure -->Modules --> Dependencies --> 点击右边的 ＋ 按钮， 选择JARS Or...
        选择IDEA的安装路径下的lib  junit:4.12 和 hamcrest-core-1.3.jar
    * */

    @Autowired
    Person person;

    @Autowired
    ApplicationContext aic;

    @Test
    public void contextLoads() {
        System.out.println("----------->"+person);
    }

    @Test
    public void testHelloService(){
        boolean b = aic.containsBean("helloService");
        System.out.println(b);
    }


}
