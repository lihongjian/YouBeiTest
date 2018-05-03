package test;

import person.li.vo.common.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjian on 2015/9/28.
 */
public class StringTest {

    public static void main(String[] args) {


//        int ai = 3;
//        transferInt(ai);
//        System.out.println(ai);
//
//        String a = "1";
//        transferString(a);
//        System.out.println(a);
//
//
//        String b = new String("1");
//        transferString(b);
//        System.out.println(b);
//
//
//        UserVo uv = new UserVo();
//        transferVo(uv);
//        System.out.println(uv.getUserPassword());
//
//
//
//        String x = "abc";
//        String y = "abc";
//        System.out.println(x==y);
//        String x1 = "abc";
//        String y1 = new String("abc");
//        System.out.println(x1 == y1);

        List<String> a = new ArrayList<String>();
        for(int i = 0 ;i < 10 ; i ++){
            a.add(String.valueOf(i));
        }

//        a.remove(o)




    }

    static void transferInt(int ai) {
        ai = 19;
    }


    static void transferString(String a) {
        a = "2";
    }

    static void transferVo(UserVo uv) {
        uv.setUserName("123213");
        uv.setUserPassword("sdfdsf");
    }
}