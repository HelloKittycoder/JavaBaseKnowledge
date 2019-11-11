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
public class ChineseCondition implements Condition {

    private static Logger logger = LogManager.getLogger(ChineseCondition.class);

    /**
     * @param context 判断条件可以使用的上下文（环境）
     * @param metadata 注解的信息
     * @return 判断是否匹配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Properties properties = new Properties();
        try {
            properties.load(context.getResourceLoader().getResource("ex04/language.properties")
                    .getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isChinese = "chinese".equals(properties.getProperty("say.method"));
        logger.debug("current chinese " + isChinese);
        return isChinese;
    }
}
