package loadclass;

class MyClass1 {
    public static final String AA = "aa";
    static {
        System.out.println("static block!");
    }
}

/**
 * Created by shucheng on 2019-10-29 下午 17:45
 */
public class Test1 {
    public static void main(String[] args) {
        // "static block!"不会被打印，因为AA前面有final
        // AA是一个字符串常量，引用一个类的常量，不会引发该类的初始化
        System.out.println("Hello!" + MyClass1.AA);
    }
}
