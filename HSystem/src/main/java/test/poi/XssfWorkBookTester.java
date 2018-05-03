package test.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import test.poi.common.ExcelHelper;
import test.poi.common.Tester;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongjian on 2015/9/29.
 */
public class XssfWorkBookTester extends Tester {

    @Override
    public Workbook getWorkBook(InputStream is) throws IOException {
        return new XSSFWorkbook(is);
    }

    @Override
    public InputStream getInputStream(String path) throws IOException {
        InputStream is = new FileInputStream(Tester.class.getClassLoader().getResource("").getPath() + path);
        return is;
    }
}
