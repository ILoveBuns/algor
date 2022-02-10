package exam.peek;

import java.util.Iterator;
import java.util.function.Consumer;


/**
 * 实现迭代器的peek方法，返回当前迭代的值，但是指针不往后移动
 * @param <T>
 */

public class PeekingIteratorImpl<T> implements PeekingIterator<T>{

    Iterator<T> iterator;
    boolean isPeek = false;
    T value;


    @Override
    public T peek() {
        if (!isPeek){
            value = iterator.next();
            isPeek = true;
        }
        return value;
    }

    @Override
    public boolean hasNext() {
//        if (isPeek){
//            return true;
//        }
//        return iterator.hasNext();

        return isPeek || iterator.hasNext();
    }

    @Override
    public T next() {
        if (!isPeek){
            return iterator.next();
        }
        isPeek = false;
        return value;
    }

    @Override
    public void remove() {
        PeekingIterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        PeekingIterator.super.forEachRemaining(action);
    }
}
