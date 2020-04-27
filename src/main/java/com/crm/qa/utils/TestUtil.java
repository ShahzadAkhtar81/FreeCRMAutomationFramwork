package com.crm.qa.utils;

import com.crm.qa.base.TestBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    // Generic method for page load time and implicit wait on page load.

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long implicitwait = 10;

    public static String testDataPath = "/Users/shahzadakhtar/Downloads/FreeCRMTestAutomation/src/main" +
            "/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";

    static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;

   /* public void switchToFrame(){
        driver.switchTo().frame("downloadFrame");
    }*/

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(testDataPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        System.out.println(sheet.getLastRowNum() + "--------" +
        sheet.getRow(0).getLastCellNum());

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                System.out.println(data[i][j]);

            }

        }

        return data;
    }

    public static void takeScreenShotAtEndOfTest() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" +System.currentTimeMillis() + ".png"));
    }

}
