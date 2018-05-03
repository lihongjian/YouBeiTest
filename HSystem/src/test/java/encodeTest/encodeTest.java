package encodeTest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class encodeTest {
    @Test
    public void endcodeTest() throws UnsupportedEncodingException {

        String a = "我";
        System.out.println(Charset.defaultCharset());
        System.out.println(a.getBytes());
    /*    Integer.toHexString()*/
        System.out.println(a.getBytes("utf-8"));
        System.out.println(a.getBytes("utf-16"));
        System.out.println(a.getBytes("gbk"));



    }
}
