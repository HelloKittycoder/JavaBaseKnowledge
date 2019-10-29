package loadclass;

class Child1 extends Parent1 {
    public static String str2 = "child1!";
    static {
        System.out.println("child block!");
    }
}

class Parent1 {
    public static String str = "parent1!";
    static {
        System.out.println("parent block!");
    }
}

/**
 * Created by shucheng on 2019-10-29 下午 17:52
 */
public class Test3 {
    public static void main(String[] args) {
        // 会打印parent和child（调用子类的静态变量，会引发父类静态代码块的初始化）
        System.out.println("Hello" + Child1.str2);
    }
}
