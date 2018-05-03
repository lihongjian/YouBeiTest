import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class main {

    @Test
    public void test() throws UnsupportedEncodingException {
     /*   int type = 4;
        switch (type){
            case 1: System.out.println(1);
            default: System.out.println(4);break;
            case 2: System.out.println(2); break;
        }*/

        String abc = "测试js atob方法的字符集";
        System.out.println(Charset.defaultCharset());
        String abcbase64  =  Base64.encodeBase64String(abc.getBytes());
        String abcbase64gbk  =  Base64.encodeBase64String(abc.getBytes("GBK"));
        String abcbase64utf16  =  Base64.encodeBase64String(abc.getBytes("utf16"));
        String abcbase64utf8  =  Base64.encodeBase64String(abc.getBytes("utf8"));
        String a = new String(Base64.decodeBase64(abcbase64utf16),"utf16");
        String b = new String(Base64.decodeBase64(abcbase64utf8),"utf8");


        System.out.println(a);
        System.out.println(b);


    }


}
