package com.kittycoder.ex05.config;

import com.kittycoder.ex05.bean.b.UserFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2019-11-12 下午 20:25
 */
@Configuration
public class Config05_b {

    @Bean
    public UserFactoryBean userFactoryBean() {
        return new UserFactoryBean();
    }
}
