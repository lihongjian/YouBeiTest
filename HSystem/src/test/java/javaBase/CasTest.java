package javaBase;

import java.util.concurrent.ConcurrentHashMap;

public class CasTest {

    private static final sun.misc.Unsafe U;
    private static final long ABASE;
    private static final int ASHIFT;

    static {
        try {
            U = sun.misc.Unsafe.getUnsafe();
            Class<?> ak = MapTestVo[].class;
            ABASE = U.arrayBaseOffset(ak);
            int scale = U.arrayIndexScale(ak);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args){
        MapTestVo[] tab = new MapTestVo[16];
        tab[0] = new  MapTestVo("a");
        tab[1] = new  MapTestVo("b");
        tab[2] = new  MapTestVo("c");
        System.out.println(((MapTestVo)U.getObjectVolatile(tab, ((long)2 << ASHIFT) + ABASE)).content);
    }
}
