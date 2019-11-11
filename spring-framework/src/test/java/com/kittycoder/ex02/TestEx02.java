package com.kittycoder.ex02;

import com.kittycoder.ex01.People;
import com.kittycoder.ex02.config.Config02;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2019-11-11 下午 23:04
 */
public class TestEx02 {

    private static Logger logger = LogManager.getLogger(TestEx02.class);

    // peo不是懒加载（在创建容器的时候已经把peo创建好了），
    // zhangsan是懒加载（在创建容器的时候zhangsan还没有创建好，在调用getBean方法的时候才开始创建zhangsan）
    @Test
    public void test1() {
        logger.debug("测试bean的懒加载");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config02.class);
        logger.debug("spring容器创建完成");
        People p = (People) ac.getBean("peo");
        logger.debug("获取peo "+ p);
        People p2 = (People) ac.getBean("zhangsan");
        logger.debug("获取zhangsan " + p2);
    }
}
