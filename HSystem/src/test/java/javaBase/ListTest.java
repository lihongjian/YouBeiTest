package javaBase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void arrayListTest(){
        List newList = new ArrayList<String>();
    }


    @Test
    public void linkedListTest(){
        List newList = new LinkedList();
        newList.add("dodo");
        newList.add("soso");
        newList.remove("dodo");

    }
}
