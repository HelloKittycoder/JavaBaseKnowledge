package com.kittycoder.ex03;

import com.kittycoder.ex01.People;
import com.kittycoder.ex03.config.Config03;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2019-11-11 下午 23:17
 */
public class TestEx03 {

    private static Logger logger = LogManager.getLogger(TestEx03.class);

    /**
     * spring里默认是singleton
     * peo是singleton，只会在创建spring容器的时候创建对象，以后无论调用多少次getBean，不会重新创建对象，取到的都是同一个对象
     * zhangsan是prototype，在创建spring容器的时候会创建对象，以后每调用一次getBean，都会重新创建一个对象
     */
    @Test
    public void test1() {
        logger.debug("测试bean的作用域（singleton和prototype）");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config03.class);
        logger.debug("spring容器创建完成");
        People p1 = (People) ac.getBean("peo");
        People p2 = (People) ac.getBean("peo");
        logger.debug("两次获取peo，p1==p2 "+ (p1 == p2));

        People z1 = (People) ac.getBean("zhangsan");
        People z2 = (People) ac.getBean("zhangsan");
        logger.debug("两次获取zhangsan，z1==z2 "+ (z1 == z2));
    }
}
