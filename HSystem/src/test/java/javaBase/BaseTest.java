package javaBase;

import org.junit.Test;

public class BaseTest {

    @Test
    public void IfElseTest(){
        String a = null;
        MapTestVo mt = null;

        if(mt == null) mt = new MapTestVo("a");

        else if(mt.equals( new MapTestVo("a"))){
            System.out.println("this is 2");
        }


    }
}
