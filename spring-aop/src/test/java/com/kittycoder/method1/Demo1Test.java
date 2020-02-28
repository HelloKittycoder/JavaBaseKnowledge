package com.kittycoder.method1;

import com.kittycoder.BaseTest;
import com.kittycoder.interceptMethod.Demo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by shucheng on 2020/2/27 20:28
 * schema-based方式的AOP
 * 切面类可以实现aop相关接口，也可以不实现。这里写的是不实现接口的方式
 */
@ContextConfiguration({"classpath:applicationContext-method1.xml"})
public class Demo1Test extends BaseTest {

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private Demo demo;

    @Test
    public void test() {
        System.out.println(ac);
        System.out.println(demo);
    }

    @Test
    public void testBeforeAdvice() {
        demo.method_a();
    }

    @Test
    public void testBeforeAdvice2() {
        demo.method_a2("张三");
    }

    // 测试后置通知
    @Test
    public void testAfterAdvice() {
        try {
            demo.method_b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试后置返回通知
    @Test
    public void testAfterReturning() {
        try {
            demo.method_b2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试环绕通知
    @Test
    public void testAroundAdvice() {
        demo.method_c();
    }

    @Test
    public void testAroundAdvice2() {
        demo.method_c2("张三");
    }

    // 测试异常通知
    @Test
    public void testExceptionAdvice() {
        try {
            demo.method_d();
        } catch (Exception e) {
        }
    }
}
