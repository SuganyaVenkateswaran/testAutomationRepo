package techUplabs.CommonUtil.BaseUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
    public static final String testDataExcelFileName = "convertcsv.xlsx"; //Global test data excel file
    public static final String currentDir = System.getProperty("user.dir");  //Main Directory of the project
    public static String testDataExcelPath = null; //Location of Test data excel file
    private static XSSFWorkbook excelWBook; //Excel WorkBook
    private static XSSFSheet excelWSheet; //Excel Sheet

    private BaseClass base;

    public ExcelUtils(BaseClass base){
        this.base = base;
    }

    public static void setExcelFileSheet(String sheetName) throws IOException {

        testDataExcelPath = currentDir + "\\src\\test\\resources\\";

        // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
    }


    public void getCellData(int noOfCol) {
        int rowCount = excelWSheet.getLastRowNum() - excelWSheet.getFirstRowNum();

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = excelWSheet.iterator();
        while (rowIterator.hasNext())
        {
        Row row = rowIterator.next();
        //For each row, iterate through all the columns
        Iterator<Cell> cellIterator = row.cellIterator();
        int count = 0;
        while (cellIterator.hasNext() && count < noOfCol)
        {
            count++;
            Cell cell = cellIterator.next();
            //Check the cell type and format accordingly
            switch (cell.getCellType())
            {
                case NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                    base.log.info("Reading data from excel file " + "rowNumber " + row.getRowNum() + " columnNumber " + count + " " + cell.getNumericCellValue());
                    break;
                case STRING:
                    System.out.print(cell.getStringCellValue() + "\t\t");
                    base.log.info("Reading data from excel file " + "rowNumber " + row.getRowNum() + " columnNumber " + count + " " + cell.getStringCellValue());
                    break;
            }
        }
        System.out.println("");
    }
    }
}