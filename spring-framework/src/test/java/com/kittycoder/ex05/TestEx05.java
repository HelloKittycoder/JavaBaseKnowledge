package com.kittycoder.ex05;

import com.kittycoder.ex05.bean.MyUtil;
import com.kittycoder.ex05.bean.UserController;
import com.kittycoder.ex05.config.Config05;
import com.kittycoder.ex05.config.Config05_a;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2019-11-12 下午 17:49
 */
public class TestEx05 {

    private static Logger logger = LogManager.getLogger(TestEx05.class);

    // 加载组件
    @Test
    public void test1() {
        logger.debug("测试@ComponentScan加载组件");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config05.class);

        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        logger.debug("开始获取userController");
        UserController userController = ac.getBean("userController", UserController.class);
        logger.debug("调用userController的test方法");
        userController.test();

        // MyUtil是使用@Component注解来创建bean的
        logger.debug("开始获取myUtil");
        MyUtil myUtil = ac.getBean("myUtil", MyUtil.class);
        logger.debug("获取注入的属性：id为" + myUtil.getId()
                + "，name为" + myUtil.getName());
    }

    @Test
    public void test2() {
        logger.debug("测试@Import加载组件");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config05_a.class);

        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        logger.debug("获取People");
        logger.debug(ac.getBean("com.kittycoder.ex01.People"));
        logger.debug("获取User01");
        logger.debug(ac.getBean("com.kittycoder.ex05.bean.a.User01"));
        logger.debug("获取User03");
        logger.debug(ac.getBean("user03"));
    }
}
