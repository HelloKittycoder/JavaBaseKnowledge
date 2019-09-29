package bitoperation;

/**
 * Created by shucheng on 2019-9-29 下午 19:42
 * 右移操作
 * Java中的位运算符：
 * >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
 * >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，
 * 则右移后高位同样补0
 *
 * 代码说明：
 * 5的二进制是0101
 * x=5>>2（>>带符号右移）
 * 将0101右移2位，为：0001
 * y=x>>>2（>>>无符号右移，左边空缺补充为0）
 * 将0001右移2位，补0，结果为：0000
 */
public class TestRightShift {

    public static void main(String[] args) {
        int x,y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println("x的值为：" + x);
        System.out.println("y的值为：" + y);
    }
}
