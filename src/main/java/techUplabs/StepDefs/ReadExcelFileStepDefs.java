package techUplabs.StepDefs;

import cucumber.api.java.en.Given;
import techUplabs.CommonUtil.BaseUtil.BaseClass;
import techUplabs.CommonUtil.BaseUtil.ExcelUtils;

public class ReadExcelFileStepDefs {

    private BaseClass base;
    public ReadExcelFileStepDefs(BaseClass base){
        this.base = base;
    }

    ExcelUtils excelUtils = new ExcelUtils(base);
    @Given("^Read excel file sheet \"([^\"]*)\" and display table with column (\\d+)$")
    public void readExcelFileSheetAndDisplayTableWithColumn(String sheetName, int noOfCol) throws Throwable {
        excelUtils.setExcelFileSheet(sheetName);
        excelUtils.getCellData(noOfCol);
    }
}
