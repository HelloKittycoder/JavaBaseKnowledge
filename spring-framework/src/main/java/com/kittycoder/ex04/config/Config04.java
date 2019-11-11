package com.kittycoder.ex04.config;

import com.kittycoder.ex04.bean.ChineseBeanImpl;
import com.kittycoder.ex04.bean.EnglishBeanImpl;
import com.kittycoder.ex04.bean.LanguageBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2019-11-11 下午 23:28
 * 根据条件类来判断是否需要创建这个bean，然后交给spring管理
 *
 * 说明：
 * 如果ChineseCondition这个类的matches方法返回true，则创建chineseBean，否则不创建；
 * 对于EnglishCondition也是同样的道理
 */
@Configuration
public class Config04 {

    private static Logger logger = LogManager.getLogger(Config04.class);

    @Bean("chineseBean")
    @Conditional(ChineseCondition.class)
    public LanguageBean getCh() {
        logger.debug("给容器中添加chineseBean");
        return new ChineseBeanImpl();
    }

    @Bean("englishBean")
    @Conditional(EnglishCondition.class)
    public LanguageBean getEn() {
        logger.debug("给容器中添加englishBean");
        return new EnglishBeanImpl();
    }
}
