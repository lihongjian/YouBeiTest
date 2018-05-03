package test.poi.common;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongjian on 2015/9/29.
 */
public class Tester {


    public Workbook getWorkBook(InputStream is) throws IOException {
        return null;
    }


    public InputStream getInputStream(String path) throws  IOException {
        return null;
    }



    public void reader(String path){
        FileInputStream is = null;
        try {
            is = new FileInputStream(Tester.class.getClassLoader().getResource("").getPath() + path);
            Workbook hwb = getWorkBook(is);
            int sheetNumber = hwb.getNumberOfSheets();
            for(int i = 0 ; i < sheetNumber; i++) {
                Sheet sheet1 = hwb.getSheetAt(i);
                for (Row row : sheet1) {
                    for (Cell cell : row) {
                        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                        System.out.print(cellRef.formatAsString());
                        System.out.print(" - ");
                        Object oCell = ExcelHelper.getCellValue(cell);
                        System.out.println("行 : " + row.getRowNum() + " -- 列 : " + cell.getColumnIndex() + " -- 值 : " + oCell);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is !=null ){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
