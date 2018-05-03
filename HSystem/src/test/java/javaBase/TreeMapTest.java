package javaBase;

import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void treeMapTest(){
        Map tm = new TreeMap();
        String b = "b";
        tm.put(b,"b");
        tm.put("c","c");
        tm.put("a","a");
        tm.put("aa","aa");
        tm.put("e","e");
        tm.put("d","d");
        tm.put("dd","dd");
        tm.put("e","ee");
        tm.put("b","b1");
        Iterator<Map.Entry> i = tm.entrySet().iterator();
        while(i.hasNext()){
            System.out.println(i.next().getValue());
        }
        System.out.println(b.compareTo("b"));

    }


    @Test
    public void tryTest(){
        MapTestVo aset = new MapTestVo("a");
        MapTestVo bset = new MapTestVo("b");
        MapTestVo xset = aset;
        aset = bset;
        bset.content = "c";
        System.out.println(xset.content);
        System.out.println(aset.content);
    }
}
