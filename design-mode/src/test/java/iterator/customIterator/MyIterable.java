package iterator.customIterator;

/**
 * Created by shucheng on 2019-10-14 下午 17:25
 */
public interface MyIterable<E> {

    MyIterator<E> createIterator();
}
