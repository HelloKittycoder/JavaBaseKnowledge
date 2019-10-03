package proxy.customjdkproxy;

import proxy.customjdkproxy.po.MyMeiPo;
import proxy.jdkdynamicproxy.po.Girl;
import proxy.jdkdynamicproxy.po.Person;

/**
 * Created by shucheng on 2019-10-3 下午 17:19
 * https://blog.csdn.net/qq_37141773/article/details/100015741
 * 纯手写实现JDK动态代理
 */
public class TestCustomJdkProxy {

    public static void main(String[] args) {
        Person person = (Person) new MyMeiPo().getInstance(new Girl());
        person.findLove();
    }
}
