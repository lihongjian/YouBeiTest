package test.poi.reader;

import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import test.poi.HssfWorkBookTester;
import test.poi.XssfWorkBookTester;
import test.poi.common.ExcelHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongjian on 2015/9/29.
 */
public class Main {

    public static void main(String[] args) {


        /**
         * 使用时间5870
         * 行1941
         * 文件大小1.5m
         */
//        long t1 = System.currentTimeMillis();
//        HssfWorkBookTester hbt = new HssfWorkBookTester();
//        hbt.reader("测试01.xls");
//        long t2 = System.currentTimeMillis();
//        System.out.println("使用时间 : " + String.valueOf(t2 - t1));


        /**
         * 文件大小11m 使用时间22067
         */
//        long t1 = System.currentTimeMillis();
//        HssfWorkBookTester hbt = new HssfWorkBookTester();
//        hbt.reader("测试011.xls");
//        long t2 = System.currentTimeMillis();
//        System.out.println("使用时间 : " + String.valueOf(t2 - t1));

        /**
         * 文件大小32m 使用时间78278
         */
//        long t1 = System.currentTimeMillis();
//        HssfWorkBookTester hbt = new HssfWorkBookTester();
//        hbt.reader("测试012.xls");
//        long t2 = System.currentTimeMillis();
//        System.out.println("使用时间 : " + String.valueOf(t2 - t1));


        /**
         * 文件大小46m 使用时间1988067
         */
//        long t1 = System.currentTimeMillis();
//        HssfWorkBookTester hbt = new HssfWorkBookTester();
//        hbt.reader("测试013.xls");
//        long t2 = System.currentTimeMillis();
//        System.out.println("使用时间 : " + String.valueOf(t2 - t1));


        /**
         * 时间13960
         * 行1997
         * 文件大小500k
         */
//        long t3 = System.currentTimeMillis();
//        XssfWorkBookTester xbt = new XssfWorkBookTester();
//        xbt.reader("测试02.xlsx");
//        long t4 = System.currentTimeMillis();
//        System.out.println("使用时间 : " + String.valueOf(t4 - t3));


        /**
         * 文件大小16.3m
         * jvm堆内存开到2g,运行了5分钟多 依旧java heap space
         * java heap space
         */
//        long t5 = System.currentTimeMillis();
//        XssfWorkBookTester xbt = new XssfWorkBookTester();
//        xbt.reader("测试03.xlsx");
//        long t6 = System.currentTimeMillis();
//        System.out.println("使用时间 : " + String.valueOf(t6 - t5));


        /**
         * 从官方文档和api上看SXSSFWorkbook没有大批量读取xml的功能
         * 所以下面尝试失败
         */
//        try {
//            XssfWorkBookTester xbt = new XssfWorkBookTester();
//            XSSFWorkbook xw = (XSSFWorkbook) xbt.getWorkBook(xbt.getInputStream("测试03.xlsx"));
//            SXSSFWorkbook wb = new SXSSFWorkbook(xw,100); // keep 100 rows in memory, exceeding rows will be flushed to disk
//            int sheetNumber = wb.getNumberOfSheets();
//            for(int i = 0 ; i < sheetNumber; i++) {
//                Sheet sheet1 = wb.getSheetAt(i);
//                for (Row row : sheet1) {
//                    for (Cell cell : row) {
//                        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//                        System.out.print(cellRef.formatAsString());
//                        System.out.print(" - ");
//                        Object oCell = ExcelHelper.getCellValue(cell);
//                        System.out.println("行 : " + row.getRowNum() + " -- 列 : " + cell.getColumnIndex() + " -- 值 : " + oCell);
//                    }
//                }
//            }
//        }catch(Exception e){
//
//            e.printStackTrace();
//
//        }




        /**
         * Read an excel file and spit out what we find.
         *
         * @param args      Expect one argument that is the file to read.
         * @throws IOException  When there is an error processing the file.
         *
         *
         * 官方文档 专用于hssfWorkBook 使用 用于节省内存
         *
         *
         * 这个方法暂时不行
         * 没有发现 值与具体的excel行,列的对照关系
         *
         */
//        try {
//            String path1 = Main.class.getClassLoader().getResource("").getPath() + "测试4.xls";
//            // create a new file input stream with the input file specified
//            // at the command line
//            FileInputStream fin = new FileInputStream(path1);
//            // create a new org.apache.poi.poifs.filesystem.Filesystem
//            POIFSFileSystem poifs = null;
//
//            poifs = new POIFSFileSystem(fin);
//
//            // get the Workbook (excel part) stream in a InputStream
//            InputStream din = poifs.createDocumentInputStream("Workbook");
//            // construct out HSSFRequest object
//            HSSFRequest req = new HSSFRequest();
//            // lazy listen for ALL records with the listener shown above
//            req.addListenerForAllRecords(new HssfWorkBookTester());
//            // create our event factory
//            HSSFEventFactory factory = new HSSFEventFactory();
//            // process our events based on the document input stream
//            factory.processEvents(req, din);
//            // once all the events are processed close our file input stream
//            fin.close();
//            // and our document input stream (don't want to leak these!)
//            din.close();
//            System.out.println("done.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


int a = 60;
        char[] bs;
        char b = (char)(a%26+64) ;
        if(a/26 > 0 ){
            char b1 = (char) (a/26+64);
            bs = new char[]{b,b1};
        }else{
            bs = new char[]{b};
        }
        System.out.println(new String(bs));

    }

}
