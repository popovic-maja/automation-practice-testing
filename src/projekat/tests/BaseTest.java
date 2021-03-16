package projekat.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class BaseTest {

    public static String[][] getExcelData(String fileName, int sheetNo) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheetAt(sheetNo);

            int rows = sheet.getPhysicalNumberOfRows(); // No of rows
            int cols = 0; // No of columns
            int tmp = 0;

            XSSFRow row;
            XSSFCell cell;
            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) cols = tmp;
                }
            }

            arrayExcelData = new String[rows - 1][cols];

            for (int r = 1; r <= rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 0; c < cols; c++) {
                        cell = row.getCell((short) c);
                        if (cell != null) {
                            arrayExcelData[r - 1][c] = getCellStringValue(cell);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }

    private static String getCellStringValue(XSSFCell cell) {

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getRawValue());
            default -> cell.getRawValue();
        };
    }
}
