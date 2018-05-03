package Hsystem.base;

/**
 * Created by hongjian on 2015/11/29.
 */
public class StringUtils {


    public static String concatArray(String[] args,String separator){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < args.length ; i++){
            String arg = args[0];
            if(i!=args.length-1){
                sb.append(arg).append(separator);
            }else{
                sb.append(arg);
            }
        }

        return sb.toString();
    }
}
