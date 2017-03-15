package data.driven.framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdactinLoginWithData extends Base {
	
	public static void main(String args[]) throws IOException, InterruptedException{
		loadConfig();
		initDriver();
		
		for(Row row: workbook.getSheetAt(0)){
			if (row==workbook.getSheetAt(0).getRow(0))
				continue;
			
			driver.get(URL);
			driver.findElement(By.id("username")).sendKeys(row.getCell(0).getStringCellValue());
			driver.findElement(By.id("password")).sendKeys(row.getCell(1).getStringCellValue());
			driver.findElement(By.id("login")).click();
			Thread.sleep(1000);			
		}
		writeFile();
	}

}
