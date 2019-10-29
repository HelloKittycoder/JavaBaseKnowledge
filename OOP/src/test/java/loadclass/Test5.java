package loadclass;

class Inner2 {
    static {
        System.out.println("Inner2 static block!");
    }
}

/**
 * Created by shucheng on 2019-10-29 下午 17:59
 */
public class Test5 {
    public static void main(String[] args) {
        // 不会打印static block
        Inner2[] inner2s = new Inner2[10];
        compare(inner2s.getClass(), Inner2[].class);
        // 以下两个不相等
        compare(inner2s.getClass(), Inner2.class);
        // 因为inner2s对应的class和Inner2.class不是同一个，所以初始化Inner2[]数组，
        // 对Inner2.class初始化没有任何影响
    }

    /**
     * 比较两个class是否相等
     * 使用示例：
     * compare(String.class, String.class);
     * compare(String.class, Object.class);
     *
     * 说明：为什么要写这个方法？
     * 因为直接写 String.class == Object.class 会报错
     *
     * @param cls1
     * @param cls2
     */
    public static void compare(Class<?> cls1, Class<?> cls2) {
        System.out.println(cls1 == cls2);
    }
}
