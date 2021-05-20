import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenUtil {
    public String path;
    public FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;



    public DataDrivenUtil(String path) {
        this.path=path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fis=new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet= workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
}
public int getCellCount(String sheetName, int rowNum) throws IOException {
    try {
        fis = new FileInputStream(path);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    try {
        workbook= new XSSFWorkbook(fis);
    } catch (IOException e) {
        e.printStackTrace();
    }
    sheet= workbook.getSheet(sheetName);
    row = sheet.getRow(rowNum);
    int cellCount = row.getLastCellNum();
    workbook.close();
    fis.close();
    return cellCount;
}
public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);
        sheet= workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell=row.getCell(colNum);

    DataFormatter formatter = new DataFormatter();
    String data;
    data= formatter.formatCellValue(cell);
    workbook.close();
    fis.close();
    return data;

}
}
