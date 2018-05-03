package test.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hongjian on 2015/12/22.
 *
 * 最主要的测试类
 */
public class reg_main {

    /**
     * java 正则表达式
     * @param args
     */

       public static void main(String[] args){

           // 按指定模式在字符串查找
           String line = "This order was placed for QT3000! OK?";
           String pattern = "(.*)(\\d{4})(.*)";

           // 创建 Pattern 对象
           Pattern r = Pattern.compile(pattern);

           // 现在创建 matcher 对象
           Matcher m = r.matcher(line);
           if (m.find()) {
               System.out.println(m.groupCount());
               System.out.println("Found value: " + m.group(0) );
               System.out.println("Found value: " + m.group(1) );
               System.out.println("Found value: " + m.group(2) );
               System.out.println("Found value: " + m.group(3) );
           } else {
               System.out.println("NO MATCH");
           }


       }
}
