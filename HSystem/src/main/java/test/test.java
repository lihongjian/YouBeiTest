package test;


/**
 * Created by hongjian on 2015/10/23.
 */
public class test {

    public static void main(String[] args){


        String a = "1";

        Integer a1 = Integer.parseInt(a);

        System.out.println(a1);

        printMessage("1","2","3");

        printMessage2("1","2","3");

    }



    public static void printMessage(Object... args) {
        for(Object arg : args){
             System.out.println(arg);
        }
    }


    public static void printMessage2(String... args) {
        for(String arg : args){
            System.out.println(arg);
        }
    }
}
