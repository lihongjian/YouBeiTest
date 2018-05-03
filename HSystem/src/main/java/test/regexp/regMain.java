package test.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hongjian on 2016/4/20.
 */
public class regMain {

    public static void main(String[] args){

//            String str1 = "zoooooo zoooooo";
//            String pattern = "zo*\\szo*";
//
//            Pattern r = Pattern.compile(pattern);
//            Matcher m = r.matcher(str1);
//            System.out.println(m.matches());
//           if (m.matches()) {
//               System.out.println(m.group());
//           }


        String line = "This order was placed for QT3000! OK?";

        String pattern = ".*";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        System.out.println(m.matches());




    }
}
