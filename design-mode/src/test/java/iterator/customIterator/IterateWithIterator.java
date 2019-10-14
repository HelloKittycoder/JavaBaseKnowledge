package iterator.customIterator;

/**
 * Created by shucheng on 2019-10-14 下午 17:40
 * 迭代器模式demo
 * https://blog.csdn.net/zhangzhetaojj/article/details/80550309
 */
public class IterateWithIterator {
    private MyIterator elements;

    public void setContainer(MyIterator newElements) {
        this.elements = newElements;
    }

    // 访问并且处理容器数据的方法
    public void printElements() {
        if (elements == null) throw new NullPointerException();
        // 访问list容器内的数据
        while (elements.hasNext()) {
            System.out.println(elements.next());
        }
    }

    public static void main(String[] args) {
        IterateWithIterator it = new IterateWithIterator();
        it.setContainer(new MyContainer<Byte>().createIterator());
        it.printElements();
    }
}
