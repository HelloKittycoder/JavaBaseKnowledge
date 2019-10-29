package loadclass;

import java.util.UUID;

class Inner {
    public static final String AA = UUID.randomUUID().toString();
    static {
        System.out.println("static block!");
    }
}

/**
 * Created by shucheng on 2019-10-29 下午 17:56
 * 注意和Test1进行对比
 */
public class Test4 {
    public static void main(String[] args) {
        // 会打印static（因为AA虽然加了final，但不是常量，所以会引发该类的初始化）
        System.out.println("Hello!" + Inner.AA);
    }
}
