package javaBase;

import java.util.AbstractSet;
import java.util.Iterator;

public class MySet  extends AbstractSet<Integer> {


    private Iterator<Integer> iter;

    public MySet(Iterator<Integer> i) {
        iter = i;
    }

    @Override
    public Iterator<Integer> iterator() {
        return iter;
    }

    @Override
    public int size() {
        return 0;
    }
}
