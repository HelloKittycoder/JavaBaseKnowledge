package com.kittycoder.method3;

import com.kittycoder.BaseTest;
import com.kittycoder.interceptMethod.Demo3;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by shucheng on 2020/2/28 12:06
 * AspectJ方式的AOP
 * 切面类可以不实现aop相关的接口
 */
@ContextConfiguration({"classpath:applicationContext-method3.xml"})
public class Demo3Test extends BaseTest {

    /*@Autowired
    private ApplicationContext ac;*/

    @Autowired
    private Demo3 demo3;

    @Test
    public void testBeforeAdvice() {
        demo3.method_a();
    }

    @Test
    public void testBeforeAdvice2() {
        demo3.method_a2("张三");
    }

    @Test
    public void testAfterAdvice() {
        try {
            demo3.method_b();
        } catch (Exception e) {}
    }

    // 测试后置返回通知
    @Test
    public void testAfterReturning() {
        try {
            demo3.method_b2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试环绕通知
    @Test
    public void testAroundAdvice() {
        demo3.method_c();
    }

    @Test
    public void testAroundAdvice2() {
        demo3.method_c2("张三");
    }

    // 测试异常通知
    @Test
    public void testExceptionAdvice() {
        try {
            demo3.method_d();
        } catch (Exception e) {
        }
    }
}
