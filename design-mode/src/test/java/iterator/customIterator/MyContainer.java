package iterator.customIterator;

/**
 * Created by shucheng on 2019-10-14 下午 17:26
 */
public class MyContainer<E> implements MyIterable<E> {

    Object[] elements;

    public MyContainer() {
        elements = new Byte[10];
        for (int i = 0; i < 10; i++) {
            elements[i] = (byte)i;
        }
    }

    @Override
    public MyIterator<E> createIterator() {
        return new Itr();
    }

    private class Itr<E> implements MyIterator<E> {
        private int cursor = -1;
        private Object[] data = elements;

        @Override
        public boolean hasNext() {
            return ++cursor < data.length;
        }

        @Override
        public E next() {
            return (E) data[cursor];
        }
    }
}
