package com.kittycoder.ex03.config;

import com.kittycoder.ex01.People;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by shucheng on 2019-11-11 下午 23:14
 */
@Configuration
public class Config03 {

    private static Logger logger = LogManager.getLogger(Config03.class);

    @Scope("singleton")
    @Bean
    public People peo() {
        logger.debug("给容器中添加peo");
        return new People();
    }

    @Scope("prototype")
    @Bean("zhangsan")
    public People people() {
        logger.debug("给容器中添加zhangsan");
        return new People(101, "张三");
    }
}
