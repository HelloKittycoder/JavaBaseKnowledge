package proxy.jdkdynamicproxy.po;

/**
 * Created by shucheng on 2019-10-2 下午 23:06
 * 相亲对象：女
 */
public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("目标要求：");
        System.out.println("高富帅");
        System.out.println("有房有车");
    }
}
