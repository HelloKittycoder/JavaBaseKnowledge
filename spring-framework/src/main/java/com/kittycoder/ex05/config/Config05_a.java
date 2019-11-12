package com.kittycoder.ex05.config;

import com.kittycoder.ex01.People;
import com.kittycoder.ex05.bean.a.UserImportBeanDefinitionRegistrar;
import com.kittycoder.ex05.bean.a.UserImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by shucheng on 2019-11-12 下午 19:59
 */
@Configuration
@Import(value = {People.class, UserImportSelector.class, UserImportBeanDefinitionRegistrar.class})
public class Config05_a {
}
