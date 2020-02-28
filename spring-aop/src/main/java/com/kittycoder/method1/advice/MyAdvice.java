package com.kittycoder.method1.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by shucheng on 2020/2/27 20:25
 */
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.kittycoder.interceptMethod.Demo.method_a())")
    public void beforeTest() {
        System.out.println("前置通知打印...");
    }

    public void beforeTest2(JoinPoint joinPoint, String name) {
        System.out.println("前置通知打印2..." + name);
    }

    public void afterTest() {
        System.out.println("后置通知打印...");
    }

    public void afterReturningTest(JoinPoint joinPoint, Object retVal) {
        System.out.println("后置返回通知打印..." + retVal);
    }

    public void aroundTest(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("通知前打印...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("通知后打印...");
    }

    public void aroundTest2(ProceedingJoinPoint proceedingJoinPoint, String name) {
        System.out.println("通知前打印2...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("通知后打印2...");
    }

    public void exceptionTest(Exception ex) {
        System.out.println(ex);
    }
}
