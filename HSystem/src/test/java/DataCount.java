public class DataCount {

    /**
     * 随便给定一个整数，给出转化成二进制数之后的1的个数
     * @param args
     */
    public static void  main(String[] args){
        int data = 100;
        int remainData = data;
        int index = -1;
        int count = 0;
        while(remainData > 0) {
            index++;
            if(remainData <  (1<<index)){
                remainData = remainData - (1<<(index-1));
                index = -1;
                count ++;
            }
            if(remainData ==  (1<<index)){
                remainData = remainData - (1<<(index));
                index = -1;
                count ++;
            }
        };
        System.out.println("1的个数为 :" + count);
    }

}
