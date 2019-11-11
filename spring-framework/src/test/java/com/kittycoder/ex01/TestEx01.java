package com.kittycoder.ex01;

import com.kittycoder.ex01.config.Config01;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-11-10 下午 23:06
 */
public class TestEx01 {

    private static Logger logger = LogManager.getLogger(TestEx01.class);

    @Test
    public void test1() {
        logger.debug("使用xml方式来加载bean");
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-ex01.xml");
        People p = ac.getBean("peo", People.class);
        System.out.println(p);
    }

    @Test
    public void test2() {
        logger.debug("使用配置类来加载bean");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config01.class);
        logger.debug("spring容器创建完成");
        People p = (People) ac.getBean("peo");
        System.out.println(p);
        People p2 = (People) ac.getBean("zhangsan");
        System.out.println(p2);
    }
}
