package com.kittycoder.ex02.config;

import com.kittycoder.ex01.People;
import com.kittycoder.ex01.config.Config01;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by shucheng on 2019-11-11 下午 21:23
 */
@Configuration
public class Config02 {

    private static Logger logger = LogManager.getLogger(Config01.class);

    @Bean
    public People peo() {
        logger.debug("给容器中添加peo");
        return new People();
    }

    @Lazy
    @Bean("zhangsan")
    public People people() {
        logger.debug("给容器中添加zhangsan");
        return new People(101, "张三");
    }
}
