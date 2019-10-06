package catchexception;

/**
 * Created by shucheng on 2019-10-7 上午 0:08
 * 打印结果：30 10
 *
 * 代码说明：
 * try和finally的return执行顺序：如果try块和finally都有返回语句，那么虽然try块中返回值在执行finally代码块之前被保存了，
 * 但是最终执行的是finally代码块的return语句，try块中的return语句不再执行
 *
 * int是基本数据类型，传的是值，方法内对形参进行修改并不会对方法外的原始变量造成影响
 */
public class Demo {

    public static void main(String[] args) {
        int num = 10;
        System.out.print(test(num) + " ");
        System.out.println(num);
    }

    public static int test(int b) {
        try {
            b += 10;
            return b;
        } catch (RuntimeException e) {
        } catch (Exception e2) {
        } finally {
            b += 10;
            return b;
        }
    }
}
