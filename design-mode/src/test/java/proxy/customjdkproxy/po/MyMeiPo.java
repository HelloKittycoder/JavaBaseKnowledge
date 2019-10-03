package proxy.customjdkproxy.po;

import proxy.customjdkproxy.reflect.MyClassLoader;
import proxy.customjdkproxy.reflect.MyInvocationHandler;
import proxy.customjdkproxy.reflect.MyProxy;
import proxy.jdkdynamicproxy.po.Person;

import java.lang.reflect.Method;

/**
 * Created by shucheng on 2019-10-3 下午 17:16
 * 媒婆 代理类
 */
public class MyMeiPo implements MyInvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，按照你的要求");
        System.out.println("开始进行海选...");
        System.out.println("------------");

        //调用的时候
        method.invoke(this.target, args);

        System.out.println("------------");
        System.out.println("选择结束，如果合适的话，就准备办事");
        return null;
    }
}
