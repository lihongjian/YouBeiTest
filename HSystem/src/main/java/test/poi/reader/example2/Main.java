package test.poi.reader.example2;

public class Main {

    /**
     * 网上的方法,处理大批量数据
     * 测试数据120000,46M,使用时间89221. 很猛
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        IRowReader reader = new RowReader();
        //ExcelReaderUtil.readExcel(reader, "F://te2003.xls");
        ExcelReaderUtil.readExcel(reader, Main.class.getClassLoader().getResource("").getPath() + "测试02.xlsx");
//        ExcelReaderUtil.readExcel(reader, Main.class.getClassLoader().getResource("").getPath() + "测试03.xlsx");//17m 46000
//        ExcelReaderUtil.readExcel(reader, Main.class.getClassLoader().getResource("").getPath() + "测试031.xlsx"); //46m 89221

        long t2 = System.currentTimeMillis();
         System.out.println("使用时间 :" + String.valueOf(t2-t1));
    }
}