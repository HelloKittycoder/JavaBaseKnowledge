package valuereference;

/**
 * Created by shucheng on 2019-10-6 下午 18:52
 * 测试引用传递
 *
 * 打印结果：hello and ab
 *
 * 代码说明：String和char[]都是对象，传递的是引用
 * str = "test ok"是给方法里str又换了一个引用，并没有改变引用所指向的对象
 * （这个写法与ch = new char[]{'c', 'd'}是一样的操作）
 *
 * ch[0] = 'c'是借助ch这个引用直接去改变引用所指向的对象，导致ch对应数组发生变化
 */
public class TestReference {

    String str = new String("hello");
    char[] ch = {'a', 'b'};

    public static void main(String[] args) {
        TestReference tr = new TestReference();
        tr.change(tr.str, tr.ch);
        System.out.print(tr.str + " and ");
        System.out.println(tr.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        // ch = new char[]{'c', 'd'};
        ch[0] = 'c';
    }
}
