package test.relativePath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by hongjian on 2015/9/29.
 */
public class Main {

    public static void main(String[] args){

        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(Main.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(Main.class.getResource(""));
        System.out.println(Main.class.getResource("/"));
        //Class文件所在路径
        System.out.println(new File("/").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));


        /**
         * 如下使用绝对路径,文件是可以找到的.
         *
         */
        try {
            FileInputStream is = new FileInputStream(Main.class.getClassLoader().getResource("").getPath() + "测试01.xls");
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }


    }

}
