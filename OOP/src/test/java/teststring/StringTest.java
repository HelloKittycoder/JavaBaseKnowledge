package teststring;

import java.lang.reflect.Field;

/**
 * Created by shucheng on 2019-10-2 下午 19:30
 * String的不可变
 * String类被final修饰，是不可继承和修改的。
 * 当一个String变量被第二次赋值时，不是在原有内存地址上修改数据，而是在内存中重新开辟一块内存地址，并指向新地址
 *
 * String类为什么被设计成是final的？
 * 1.不可变性支持线程安全
 * 2.不可变性支持字符串常量池，提升性能
 * 3.String字符串作为最常用数据类型之一，不可变防止了随意修改，保证了数据的安全性。
 *
 * 正常情况下，Java的String字符串是final且不可变的。不过可以通过特殊手段修改它的内容。
 * String类的主要成员字段value是个char数组，而且是用final修饰的。final修饰的字段创建后就不可改变。
 * 虽然value是不可变，但也只是value的引用地址不可变，挡不住数组是可变的事实。（引用数据类型被final修饰，只是引用地址不可变，但是数据的内容是可变的）
 *
 * 参考链接：https://www.cnblogs.com/zengming/p/9367088.html
 */
public class StringTest {

    public static void main(String[] args) throws Exception {
        String test = "immutable String";
        String test1 = test;
        String test2 = new String(test);
        String test3 = new String(test.toCharArray());
        Field values = String.class.getDeclaredField("value");
        values.setAccessible(true);
        char[] chars = (char[]) values.get(test);
        chars[0] = 'u';
        chars[1] = 'n';
        System.out.println("test==test1:" + (test == test1));
        System.out.println("test==test2:" + (test == test2));
        System.out.println("test1==test2:" + (test1 == test2));
        System.out.println("test:" + test + "  test1:" + test1
            + "  test2:" + test2 + "  test3:" + test3);
    }
}
