package com.kittycoder.method2.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by shucheng on 2020/2/28 17:02
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println(ex);
    }
}
