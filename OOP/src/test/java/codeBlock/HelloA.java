package codeBlock;

/**
 * Created by shucheng on 2019-9-29 上午 0:35
 * 测试代码块的加载顺序
 */
public class HelloA {
    public HelloA() {
        System.out.println("A的构造函数");
    }

    {
        System.out.println("A的构造代码块");
    }

    static {
        System.out.println("A的静态代码块");
    }

    public static void main(String[] args) {
        HelloA a = new HelloA();
        // HelloA a1 = new HelloA();
    }
}
