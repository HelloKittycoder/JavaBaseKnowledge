package com.kittycoder.ex05.bean.a;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by shucheng on 2019-11-12 下午 20:11
 */
public class UserImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类
     * 把所有需要交给spring来管理的bean先注册成BeanDefinition
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /**
         * 在这里可以进行定制化的业务逻辑操作
         * 1.条件判断
         * 2.环境检测
         */
        RootBeanDefinition beanDefinition = new RootBeanDefinition(User03.class);
        registry.registerBeanDefinition("user03", beanDefinition);
    }
}
