package arithmetic;

import org.junit.Test;

/**
 * Created by shucheng on 2019-11-1 上午 9:29
 * 测试运算符的优先级
 * https://www.cnblogs.com/cjm123/p/8145604.html
 */
public class TestPriority {

    // 测试取余和自增的优先级
    // 自增高于取余
    @Test
    public void test1() {
        int i = 1;
        System.out.println(++i % 5); // 2
        System.out.println(i); // 2
    }
}
