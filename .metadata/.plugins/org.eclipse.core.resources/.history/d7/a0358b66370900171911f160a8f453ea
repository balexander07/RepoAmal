package data.driven.framework;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdactinBookTicketWithData {
	
	public static void main(String[] args) throws IOException {
		AdactinLoginWithData.loadConfig();
		AdactinLoginWithData.initDriver();
		AdactinLoginWithData.correctLogin();
		
		for(Row row: AdactinLoginWithData.workbook.getSheetAt(1)){
			if (row==AdactinLoginWithData.workbook.getSheetAt(1).getRow(0))
				continue;
			
			new Select(AdactinLoginWithData.driver.findElement(By.id("location"))).selectByVisibleText(row.getCell(0).getStringCellValue());
		}
		AdactinLoginWithData.workbook.close();
	}

}
