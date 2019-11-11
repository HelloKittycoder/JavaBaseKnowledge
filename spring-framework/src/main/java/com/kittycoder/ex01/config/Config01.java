package com.kittycoder.ex01.config;

import com.kittycoder.ex01.People;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2019-11-11 下午 21:23
 */
@Configuration
public class Config01 {

    private static Logger logger = LogManager.getLogger(Config01.class);

    @Value("#{2*10}")
    private Integer configId;
    @Value("config01")
    private String configName;

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

    public Integer getConfigId() {
        return configId;
    }

    public String getConfigName() {
        return configName;
    }
}
