package test.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hongjian on 2015/12/22.
 *
 * ����Ҫ�Ĳ�����
 */
public class reg_main {

    /**
     * java ������ʽ
     * @param args
     */

       public static void main(String[] args){

           // ��ָ��ģʽ���ַ�������
           String line = "This order was placed for QT3000! OK?";
           String pattern = "(.*)(\\d{4})(.*)";

           // ���� Pattern ����
           Pattern r = Pattern.compile(pattern);

           // ���ڴ��� matcher ����
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
