package util;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtil {
    Workbook xlWorkBook;
    Sheet xlSheet;
    int rowNo;



    /* Constructor Started */
    public ExcelUtil() {

    }

    public ExcelUtil(String excelPathWithName) throws IOException {
        setWorkBook(excelPathWithName);
    }

    public ExcelUtil(String excelPathWithName, String sheetName) throws IOException {
        setSheet(excelPathWithName, sheetName);
    }

    public ExcelUtil(String excelPathWithName, int sheetNo) throws IOException {
        setSheet(excelPathWithName, sheetNo);

    }

    public ExcelUtil(Workbook xlWorkBook, Sheet xlSheet, int rowNo) {
        this.xlWorkBook = xlWorkBook;
        this.xlSheet = xlSheet;
        this.rowNo = rowNo;
    }

    /* Constructor Completed */

    public Workbook getWorkBook(String excelPathWithName) throws IOException {
        Workbook xlWorkBook;
        if ((FilenameUtils.getExtension(excelPathWithName)).equalsIgnoreCase("xlsx")) {
            xlWorkBook = new XSSFWorkbook(excelPathWithName);
//			System.out.println("xlsx object created");
        } else {
            xlWorkBook = new HSSFWorkbook();
//			System.out.println("xls object created");

        }
        return xlWorkBook;

    }

    public void setWorkBook(String excelPathWithName) throws IOException {
        this.xlWorkBook = getWorkBook(excelPathWithName);
    }

    public Sheet getSheet(String excelPathWithName, String sheetName) throws IOException {
        return this.getWorkBook(excelPathWithName).getSheet(sheetName);

    }

    public Sheet getSheet(String sheetName) {
        return this.xlWorkBook.getSheet(sheetName);

    }

    public void setSheet(String excelPathWithName, String sheetName) throws IOException {
        this.xlWorkBook = getWorkBook(excelPathWithName);
        this.xlSheet = getSheet(sheetName);
    }

    public void setSheet(String sheetName) throws IOException {
        this.xlSheet = getSheet(sheetName);
    }

    // *****************************************************************************************************//
    public Sheet getSheet(String excelPathWithName, int sheetNo) throws IOException {
        return this.getWorkBook(excelPathWithName).getSheetAt(sheetNo);

    }

    public Sheet getSheet(int sheetNo) {
        return this.xlWorkBook.getSheetAt(sheetNo);

    }

    public void setSheet(String excelPathWithName, int sheetNo) throws IOException {
        this.xlWorkBook = getWorkBook(excelPathWithName);
        this.xlSheet = getSheet(sheetNo);
    }

    public void setSheet(int sheetNo) throws IOException {
        this.xlSheet = getSheet(sheetNo);
    }

    // *****************************************************************************************************//
    /* Get specific Row */
    public Row getRow(String excelPathWithName, String sheetName, int rowNo) throws IOException {
        return this.getSheet(excelPathWithName, sheetName).getRow(rowNo);
    }

    public Row getRow(String sheetName, int rowNo) throws IOException {
        return this.getSheet(sheetName).getRow(rowNo);
    }

    public Row getRow(Sheet sheet, int rowNo) throws IOException {
        return sheet.getRow(rowNo);
    }

    public Row getRow(int rowNo) throws IOException {
        return this.xlSheet.getRow(rowNo);
    }

    /* Get all Rows */
    public List<Row> getRow(String excelPathWithName, String sheetName) throws IOException {
        List<Row> rowArrayList = new ArrayList<Row>();
        for (int currentRow = 0; currentRow <= this.getRowCount(excelPathWithName, sheetName); currentRow++) {
            rowArrayList.add(this.getSheet(sheetName).getRow(currentRow));
        }
        return rowArrayList;
    }

    public List<Row> getRow(String sheetName) throws IOException {
        List<Row> rowArrayList = new ArrayList<Row>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetName); currentRow++)
            rowArrayList.add(this.getSheet(sheetName).getRow(currentRow));
        return rowArrayList;
    }

    public List<Row> getRow(Sheet sheet) throws IOException {
        List<Row> rowArrayList = new ArrayList<Row>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheet); currentRow++)
            rowArrayList.add(sheet.getRow(currentRow));
        return rowArrayList;
    }
    // *****************************************************************************************************//
    public List<String> getCol(Sheet sheet, int colNo) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheet); currentRow++)
            rowArrayList.add(getCellData(sheet, currentRow, colNo));
        return rowArrayList;
    }

    public List<String> getCol(String sheetName, int colNo) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetName); currentRow++)
            rowArrayList.add(getCellData(sheetName, currentRow, colNo));
        return rowArrayList;
    }

    public List<String> getCol(String fileName, String sheetName, int colNo) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetName); currentRow++)
            rowArrayList.add(getCellData(fileName, sheetName, currentRow, colNo));
        return rowArrayList;
    }

    public List<String> getCol(int sheetNo, int colNo) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetNo); currentRow++)
            rowArrayList.add(getCellData(sheetNo, currentRow, colNo));
        return rowArrayList;
    }

    public List<String> getCol(int colNo) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(this.xlSheet); currentRow++)
            rowArrayList.add(getCellData(this.xlSheet, currentRow, colNo));
        return rowArrayList;
    }

    public List<String> getCol(String colName) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(this.xlSheet); currentRow++)
            rowArrayList.add(getCellData(this.xlSheet, currentRow, colName));
        return rowArrayList;
    }

    public List<String> getCol(String fileName, int sheetNo, int colNo) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(fileName, sheetNo); currentRow++)
            rowArrayList.add(getCellData(fileName, sheetNo, currentRow, colNo));
        return rowArrayList;
    }

    public List<String> getCol(Sheet sheet, String colName) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheet); currentRow++)
            rowArrayList.add(getCellData(sheet, currentRow, colName));
        return rowArrayList;
    }

    public List<String> getCol(String sheetName, String colName) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetName); currentRow++)
            rowArrayList.add(getCellData(sheetName, currentRow, colName));
        return rowArrayList;
    }

    public List<String> getCol(String fileName, String sheetName, String colName) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetName); currentRow++)
            rowArrayList.add(getCellData(fileName, sheetName, currentRow, colName));
        return rowArrayList;
    }

    public List<String> getCol(int sheetNo, String colName) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetNo); currentRow++)
            rowArrayList.add(getCellData(sheetNo, currentRow, colName));
        return rowArrayList;
    }

    public List<String> getCol(String fileName, int sheetNo, String colName) throws IOException {
        List<String> rowArrayList = new ArrayList<String>();
        for (int currentRow = 0; currentRow <= this.getRowCount(sheetNo); currentRow++)
            rowArrayList.add(getCellData(fileName, sheetNo, currentRow, colName));
        return rowArrayList;
    }
    // *****************************************************************************************************//

    public String getCellData(String excelPathWithName, String sheetName, int rowNo, int colNo) throws IOException {
        return getCellVal(this.getSheet(excelPathWithName, sheetName).getRow(rowNo).getCell(colNo));
    }

    public String getCellData(String excelPathWithName, int sheetNo, int rowNo, String colName) throws IOException {

        int colNo = this.getColHeaderNo(getSheet(sheetNo), colName);
        return getCellVal(this.getSheet(excelPathWithName, sheetNo).getRow(rowNo).getCell(colNo));
    }

    public String getCellData(String sheetName, int rowNo, int colNo) throws IOException {
        return getCellVal(this.getSheet(sheetName).getRow(rowNo).getCell(colNo));
    }

    public String getCellData(int sheetNo, int rowNo, String colName) throws IOException {
        xlSheet=getSheet(sheetNo);
        int colNo = this.getColHeaderNo(xlSheet, colName);
        return getCellVal(xlSheet.getRow(rowNo).getCell(colNo));
    }

    public String getCellData(Sheet sheet, int rowNo, int colNo) throws IOException {
        return getCellVal(sheet.getRow(rowNo).getCell(colNo));
    }

    public String getCellData(int rowNo, int colNo) throws IOException {
        return getCellVal(this.xlSheet.getRow(rowNo).getCell(colNo));
    }

    public String getCellData(Row row, int colNo) throws IOException {
        // return getCellVal(row.getCell(colNo));
        return getCellVal(row.getCell(colNo));
    }

    public String getCellData(String excelPathWithName, String sheetName, int rowNo, String colName)
            throws IOException {
        Sheet sheet = getSheet(excelPathWithName, sheetName);
        int colNo = this.getColHeaderNo(sheet, colName);
        return getCellVal(this.getSheet(excelPathWithName, sheetName).getRow(rowNo).getCell(colNo));
    }

    public String getCellData(String sheetName, int rowNo, String colName) throws IOException {
        Sheet sheet = getSheet(sheetName);
        int colNo = this.getColHeaderNo(sheet, colName);
        return getCellVal(this.getSheet(sheetName).getRow(rowNo).getCell(colNo));
    }

    public String getCellData(Sheet sheet, int rowNo, String colName) throws IOException {
        int colNo = this.getColHeaderNo(sheet, colName);
        return getCellVal(sheet.getRow(rowNo).getCell(colNo));
    }

    public String getCellData(int rowNo, String colName) throws IOException {
        int colNo = this.getColHeaderNo(this.xlSheet, colName);
        return getCellVal(this.xlSheet.getRow(rowNo).getCell(colNo));
    }

    public String getCellData(String sheetName, Row row, String colName) throws IOException {
        int colNo = this.getColHeaderNo(getSheet(sheetName), colName);
        return getCellVal(row.getCell(colNo));
    }

    public String getCellData(Row row, String colName) {
        try {
            int colNo = this.getColHeaderNo(this.xlSheet, colName);
            return getCellVal(row.getCell(colNo));
        } catch (Exception e) {
            return null;
        }

    }

    // *****************************************************************************************************//
    public String getCellData(String excelPathWithName, int sheetNo, int rowNo, int colNo) throws IOException {
        return getCellVal(this.getSheet(excelPathWithName, sheetNo).getRow(rowNo).getCell(colNo));
    }

    public String getCellData(int sheetNo, int rowNo, int colNo) throws IOException {
        return getCellVal(this.getSheet(sheetNo).getRow(rowNo).getCell(colNo));
    }

    // get Cell data based on row No and column no
    public String getCellVal(Cell col) {
        String cellVal = "";
        int cell_Type=3;
        if (col!=null)
            cell_Type = col.getCellType();
        switch (cell_Type) {
            case 0:
                cellVal = new DataFormatter().formatCellValue(col);
                break;
            case 1:
                cellVal = col.getStringCellValue();
                break;
            case 2:
                switch (col.getCachedFormulaResultType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        cellVal = new BigDecimal(col.getNumericCellValue()).toString();
                        break;
                    case Cell.CELL_TYPE_STRING:
                        cellVal = col.getStringCellValue();
                        break;
                    default:
                        System.out.print("Report to automation team need to implement the logic for the cell type in formula:"
                                + col.getCachedFormulaResultType());
                        break;
                }
                break;
            case 3:
                cellVal = "";
                break;
            case 4:
                cellVal = Boolean.toString(col.getBooleanCellValue());
                break;
            case 5:
                cellVal = Byte.toString(col.getErrorCellValue());
                break;
            default:
                System.out.print("Report to automation team need to implement the logic for the cell type:" + cell_Type);
                break;
        }
        return cellVal;
    }

    public int getColHeaderNo(Sheet sheet, String colName) throws IOException {
        int colNo = -1;
        int totCol = getColCount(sheet, 0);
        int currentColNo;
        for (currentColNo = 0; currentColNo <= totCol; currentColNo++) {
            if (getCellData(sheet, 0, currentColNo).equalsIgnoreCase(colName)) {
                colNo = currentColNo;
                break;
            } else if (currentColNo == totCol) {
                System.out.println("Column header not found in excel file: " + colName);
            }
        }
        return colNo;
    }

    public int getColHeaderNo(String sheetName, String colName) throws IOException {
        Sheet sheet = getSheet(sheetName);
        int colNo = -1;
        int totCol = getColCount(sheet, 0);
        int currentColNo;
        for (currentColNo = 0; currentColNo <= totCol; currentColNo++) {
            if (getCellData(sheet, 0, currentColNo).equalsIgnoreCase(colName)) {
                colNo = currentColNo;
                break;
            } else if (currentColNo == totCol) {
                System.out.println("Column header not found in excel file: " + colName);
            }
        }
        return colNo;
    }

    // get total columns of specific column of specific sheet sheet
    public int getColCount(Sheet sheet, int rowNo) {
        return sheet.getRow(rowNo).getLastCellNum();
    }

    public int getColCount(int rowNo) {
        return this.xlSheet.getRow(rowNo).getLastCellNum();
    }

    // get total rows of specific sheet
    public int getRowCount(Sheet sheet) {
        return sheet.getLastRowNum();
    }

    public int getRowCount(String excelPathWithName, String sheetName) throws IOException {
        return getSheet(excelPathWithName, sheetName).getLastRowNum();
    }

    public int getRowCount(String excelPathWithName, int sheetNo) throws IOException {
        return getSheet(excelPathWithName, sheetNo).getLastRowNum();
    }
    public int getRowCount(String sheetName) {
        return getSheet(sheetName).getLastRowNum();
    }

    public int getRowCount(int sheetNo) {
        return getSheet(sheetNo).getLastRowNum();
    }

    public int getRowCount() {
        return this.xlSheet.getLastRowNum();
    }
}