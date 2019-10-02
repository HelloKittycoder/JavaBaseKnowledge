package multithread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shucheng on 2019-10-2 上午 11:05
 * 多线程中交替打印的问题
 *
 * 打印结果（有很多种可能的结果）：
 * ABCABCABC
 * ABCAABCABC
 * ABCABCABCABC
 * AABBCCAABBCC
 *
 * 结果说明：
 * 有两个线程（记成t1和t2）在操作names
 * run方法里的add和printAll方法的内部是线程安全的，但是run方法中的代码块不是线程安全的
 * 所以可能出现这样的执行顺序：
 * ----t1----|----t2----
 *  add("A") |
 *  add("B") |
 *  add("C") |
 *  printAll |
 *           | add("A")
 *           | add("B")
 *           | add("C")
 *           | printAll
 *
 * ----t1----|----t2----
 *  add("A") |
 *  add("B") |
 *  add("C") |
 *           | add("A")
 *  printAll |
 *           | add("B")
 *           | add("C")
 *           | printAll
 *
 * ----t1----|----t2----
 *  add("A") |
 *  add("B") |
 *  add("C") |
 *           | add("A")
 *           | add("B")
 *           | add("C")
 *  printAll |
 *           | printAll
 *
 * ----t1----|----t2----
 *  add("A") |
 *           | add("A")
 *  add("B") |
 *           | add("B")
 *  add("C") |
 *           | add("C")
 *  printAll |
 *           | printAll
 *
 * 其实从上面的图中可以画出很多种可能性，可以总结出一些简单的规律：
 * 1. t1输出的元素个数大于等于3个，小于等于6个
 * 2. t2输出的元素个数必须等于6个
 * 3. 最终打印结果中把靠后6个（t2打印的）排除掉，前面剩下的部分就是t1打印的，
 * t1打印的结果一定是从t2中前面截取的某个部分（这个结论可以用于排除掉一些明显不对的打印结果）
 */
public class NameList {

    private List names = new ArrayList();
    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + "");
        }
    }

    public static void main(String[] args) {
        final NameList s1 = new NameList();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    s1.add("A");
                    s1.add("B");
                    s1.add("C");
                    s1.printAll();
                }
            }.start();
        }
    }
}
