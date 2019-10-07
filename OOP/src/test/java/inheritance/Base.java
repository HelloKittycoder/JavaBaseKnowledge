package inheritance;

/**
 * Created by shucheng on 2019-10-7 上午 10:52
 * 复习父类与子类中各种成员的加载次序（可以参看SuperAndSub）
 */
public class Base {
    private String baseName = "base";
    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";
        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}
