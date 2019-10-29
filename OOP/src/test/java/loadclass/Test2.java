package loadclass;

class Child extends Parent {
    static {
        System.out.println("child block");
    }
}

class Parent {
    public static String str = "Hello!";
    static {
        System.out.println("parent block!");
    }
}

/**
 * Created by shucheng on 2019-10-29 下午 17:48
 */
public class Test2 {
    public static void main(String[] args) {
        // child和parent的静态块只会打印parent的
        System.out.println("Hello" + Parent.str);
    }
}
