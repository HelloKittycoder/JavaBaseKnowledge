package com.kittycoder.ex04.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by shucheng on 2019-11-11 下午 23:33
 */
public class EnglishCondition implements Condition {

    private static Logger logger = LogManager.getLogger(EnglishCondition.class);

    /**
     * @param context 判断条件可以使用的上下文（环境）
     * @param metadata 注解的信息
     * @return 判断是否匹配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 通过context可以获取很多东西，然后进行定制开发
        // 获取工厂类
        // context.getBeanFactory();
        // 获取资源加载器
        // context.getResourceLoader();

        Properties properties = new Properties();
        try {
            properties.load(context.getResourceLoader().getResource("ex04/language.properties")
                    .getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isEnglish = "english".equals(properties.getProperty("say.method"));
        logger.debug("current english " + isEnglish);
        return isEnglish;
    }
}
