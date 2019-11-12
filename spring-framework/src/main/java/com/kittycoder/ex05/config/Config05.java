package com.kittycoder.ex05.config;

import com.kittycoder.ex01.People;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2019-11-12 下午 17:48
 */
@Configuration
@ComponentScan("com.kittycoder.ex05.bean")
public class Config05 {

    private static Logger logger = LogManager.getLogger(Config05.class);

    @Bean
    public People peo() {
        logger.debug("给容器中添加peo");
        return new People();
    }

    @Bean("zhangsan")
    public People people() {
        logger.debug("给容器中添加zhangsan");
        return new People(101, "张三");
    }
}
