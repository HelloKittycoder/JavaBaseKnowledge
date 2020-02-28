package com.kittycoder.interceptMethod;

/**
 * Created by shucheng on 2020/2/27 20:02
 */
public class Demo3 {

    // 用来测前置通知
    public void method_a() {
        System.out.println("执行Demo.method_a方法");
    }

    // 用来测前置通知
    public void method_a2(String name) {
        System.out.println("执行Demo.method_a2方法" + name);
    }

    // 用来测后置通知
    public void method_b() {
        System.out.println("执行Demo.method_b方法");
        System.out.println(1/0);
    }

    // 用来测后置返回通知
    public int method_b2() {
        System.out.println("执行Demo.method_b2方法");
        return 1;
    }

    // 用来测环绕通知
    public void method_c() {
        System.out.println("执行Demo.method_c");
    }

    public void method_c2(String name) {
        System.out.println("执行Demo.method_c2" + name);
    }

    // 用来测试异常通知
    public void method_d() {
        System.out.println(1/0);
    }
}
