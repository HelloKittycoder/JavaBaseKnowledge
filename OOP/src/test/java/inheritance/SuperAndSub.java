package inheritance;

/**
 * Created by shucheng on 2019-10-7 上午 11:42
 * 验证java类中各种成员的加载顺序
 * https://blog.csdn.net/qq_35568099/article/details/82427741
 *
 * Sub s3 = new Sub();的打印结果（和Super s1 = new Sub();一样）
 * 加载Super的静态变量
 * 加载Super的静态块
 * 加载Sub的静态变量
 * 加载Sub的静态块
 * 加载Super的实例变量
 * 加载Super的普通块
 * 加载Super的构造器
 * 加载Sub的实例变量
 * 加载Sub的普通块
 * 加载Sub的构造器
 *
 * 解释：
 * 1. 父类先于子类
 * 2. 静态先于实例
 * 3. 变量先于代码块
 * 4. 在实例化时：普通块先于构造器
 *
 * 只看一个类（不管父子类关系）：静态变量->静态块->实例变量->普通块->构造器
 * （可以通过Super s2 = new Super();来验证）
 */
public class SuperAndSub {

    public static void main(String[] args) {
        // Super s1 = new Sub();
        // Super s2 = new Super();
        Sub s3 = new Sub();
    }
}

class Super {
    static int a = getA();

    static {
        System.out.println("加载Super的静态块");
    }

    int b = getB();

    {
        System.out.println("加载Super的普通块");
    }

    Super() {
        System.out.println("加载Super的构造器");
    }

    static int getA() {
        System.out.println("加载Super的静态变量");
        return 1;
    }

    static int getB() {
        System.out.println("加载Super的实例变量");
        return 2;
    }
}

class Sub extends Super {
    static int c = getC();

    static {
        System.out.println("加载Sub的静态块");
    }

    int d = getD();

    {
        System.out.println("加载Sub的普通块");
    }

    Sub() {
        System.out.println("加载Sub的构造器");
    }

    static int getC() {
        System.out.println("加载Sub的静态变量");
        return 1;
    }

    static int getD() {
        System.out.println("加载Sub的实例变量");
        return 2;
    }
}
