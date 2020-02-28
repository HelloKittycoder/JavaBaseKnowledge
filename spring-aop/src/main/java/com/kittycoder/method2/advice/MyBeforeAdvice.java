package com.kittycoder.method2.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by shucheng on 2020/2/28 12:07
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行的方法：" + method);
        System.out.println("参数：" + args);
        System.out.println("拦截的目标对象：" + target);
    }
}
