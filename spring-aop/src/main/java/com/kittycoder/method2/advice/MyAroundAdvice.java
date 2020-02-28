package com.kittycoder.method2.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by shucheng on 2020/2/28 14:00
 */
public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕通知前---------：");
        Object rval = invocation.proceed();
        System.out.println("环绕通知后---------：");
        return rval;
    }
}
