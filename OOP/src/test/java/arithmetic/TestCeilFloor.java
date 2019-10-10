package arithmetic;

/**
 * Created by shucheng on 2019-10-10 上午 8:58
 * 测试ceil和floor
 *
 * 打印结果：
 * Ceil d1=-0.0
 * Floor d1=-1.0
 *
 * 说明：
 * Math.ceil(-0.5)=-0
 * ceil方法上有这么一段注释：If the argument value is less than zero but
 * greater than -1.0, then the result is negative zero.
 */
public class TestCeilFloor {

    public static void main(String[] args) {
        double d1 = -0.5;
        System.out.println("Ceil d1=" + Math.ceil(d1));
        System.out.println("Floor d1=" + Math.floor(d1));
    }
}
