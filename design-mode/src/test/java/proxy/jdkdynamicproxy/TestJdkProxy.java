package proxy.jdkdynamicproxy;

import proxy.jdkdynamicproxy.po.Girl;
import proxy.jdkdynamicproxy.po.MeiPo;
import proxy.jdkdynamicproxy.po.Person;

/**
 * Created by shucheng on 2019-10-2 下午 23:20
 * https://blog.csdn.net/qq_37141773/article/details/91818295
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件，可以得到$Proxy0的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Person obj = (Person) new MeiPo().getInstance(new Girl());
        System.out.println("实际的被代理对象class是：" + obj.getClass());
        obj.findLove();
    }
}
