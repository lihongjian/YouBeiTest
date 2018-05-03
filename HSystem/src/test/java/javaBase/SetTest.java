package javaBase;

import org.junit.Test;

import java.util.ArrayList;

public class SetTest {

    @Test
    public void setTest(){

        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);

        MySet set = new MySet(array.iterator());
        System.out.println(set);
    }
}
