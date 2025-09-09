package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Utility class to read data from Excel files.
 * Supports .xlsx and .xls formats.
 */
public class ExcelReader {

    /**
     * Reads a cell value from the Excel file.
     *
     * @param filePath  The path to the Excel file
     * @param sheetName The sheet name
     * @param rowNum    The row number (1-based index)
     * @param colNum    The column number (0-based index)
     * @return The cell value as a String
     */
    public static String getCellValue(String filePath, String sheetName, int rowNum, int colNum) {
        FileInputStream fis = null;
        Workbook workbook = null;
        String cellValue = "";

        try {
            fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filePath);
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                throw new RuntimeException("Row " + rowNum + " not found in sheet: " + sheetName);
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                return "";
            }

            DataFormatter formatter = new DataFormatter();
            cellValue = formatter.formatCellValue(cell);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel file: " + e.getMessage());
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return cellValue;
    }
}
