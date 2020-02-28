package com.kittycoder.method3.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by shucheng on 2020/2/28 19:53
 */
@Aspect
public class MyAspectAdvice {

    @Before("execution(* com.kittycoder.interceptMethod.Demo3.method_a())")
    public void beforeTest() {
        System.out.println("前置通知打印..." );
    }

    @Before("execution(* com.kittycoder.interceptMethod.Demo3.method_a2(String)) && args(name)")
    public void beforeTest2(JoinPoint joinPoint, String name) {
        System.out.println("前置通知打印2..." + name);
    }

    @After("execution(* com.kittycoder.interceptMethod.Demo3.method_b())")
    public void afterTest() {
        System.out.println("后置通知打印...");
    }

    @AfterReturning(pointcut = "execution(* com.kittycoder.interceptMethod.Demo3.method_b2())",
        returning = "retVal")
    public void afterReturningTest(JoinPoint joinPoint, Object retVal) {
        System.out.println("后置返回通知打印..." + retVal);
    }

    @Around("execution(* com.kittycoder.interceptMethod.Demo3.method_c())")
    public void aroundTest(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("通知前打印...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("通知后打印...");
    }

    @Around("execution(* com.kittycoder.interceptMethod.Demo3.method_c2(String)) && args(name)")
    public void aroundTest2(ProceedingJoinPoint proceedingJoinPoint, String name) {
        System.out.println("通知前打印2...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("通知后打印2...");
    }

    @AfterThrowing(pointcut = "execution(* com.kittycoder.interceptMethod.Demo3.method_d())", throwing = "ex")
    public void exceptionTest(Exception ex) {
        System.out.println(ex);
    }
}
