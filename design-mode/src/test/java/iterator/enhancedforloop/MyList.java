package iterator.enhancedforloop;

import java.util.Iterator;

/**
 * Created by shucheng on 2019-10-14 下午 18:00
 * 自定义一个可以使用增强for循环进行遍历的类
 * https://blog.csdn.net/china_demon/article/details/53861813
 *
 * 要点：实现Iterable接口，在MyList内部返回一个Iterator实现
 */
public class MyList<E> implements Iterable<E> {

    Object[] arr = new Object[10];
    int size = 0;

    public void add(E e) {
        arr[size++] = e;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                return (E) arr[cursor++];
            }
        };
    }
}
