package com.kittycoder.ex04;

import com.kittycoder.ex04.bean.LanguageBean;
import com.kittycoder.ex04.config.Config04;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2019-11-12 上午 0:04
 */
public class TestEx04 {

    private static Logger logger = LogManager.getLogger(TestEx04.class);

    @Test
    public void test1() {
        logger.debug("条件选择加载");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config04.class);
        logger.debug("spring容器创建完成");

        String[] names = ac.getBeanNamesForType(LanguageBean.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
