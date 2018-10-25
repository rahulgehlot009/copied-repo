package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtile extends TestBase {
	public static long page_load_TimeOut=20;
	public static long Implicit_wait=10;
	public static String TESTDATA_SHEET_PATH = "D:\\eclipse\\GitHub\\crm-project\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	public void mouseOver(WebElement element)
	{
		
		Actions action= new Actions(driver);
		action.moveToElement(element).perform();
	}
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
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
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = "D:\\eclipse\\GitHub\\crm-project\\screenshots";
		FileHandler.copy(scrFile, new File(currentDir + "\\screenshot\\" + System.currentTimeMillis() + ".png"));
		

		
		}
	public static void waitMethod(int timeout,WebElement element)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}
	

}
