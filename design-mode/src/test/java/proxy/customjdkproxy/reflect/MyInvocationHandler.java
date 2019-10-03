package proxy.customjdkproxy.reflect;

import java.lang.reflect.Method;

/**
 * Created by shucheng on 2019-10-3 下午 16:28
 * 用于自定义代理处理逻辑
 */
public interface MyInvocationHandler {

    /**
     * invoke
     * @param proxy
     * @param method
     * @param args 方法调用时所需要的参数
     * @return Object
     * @throws Throwable 异常
     */
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
