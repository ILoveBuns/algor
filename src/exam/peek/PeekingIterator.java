package exam.peek;

import java.util.Iterator;

interface PeekingIterator<T> extends Iterator<T> {
    T peek();
}

// [1, 2, 3, 4, 5]
// next() 1
// peek() 2
// peek() 2
// next() 2
// next() 3