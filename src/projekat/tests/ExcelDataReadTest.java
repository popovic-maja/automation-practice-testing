package projekat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ExcelDataReadTest extends  BaseTest{

    @Test
    void testExcelDataExtract() {
        String[][] data = getExcelData("MOCK_DATA.xlsx", 0);
        Assert.assertNotNull(data);

        for (String[] red : data) {
            System.out.println(Arrays.toString(red));
        }
    }
}
